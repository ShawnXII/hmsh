package com.hmsh.admin.controller;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.common.utils.BinaryUtil;
import com.aliyun.oss.model.MatchMode;
import com.aliyun.oss.model.PolicyConditions;
import com.hmsh.admin.security.support.SecurityUserHolder;
import com.hmsh.admin.vo.user.Account;

/**
 * 获取公共的接口
 * 
 * @author ShawnXII
 *
 */
@Controller
@RequestMapping("/common")
public class CommonController {
	
	private static final Logger log = LoggerFactory.getLogger(CommonController.class);
	
	@Value("${oss.endpoint}")
	private String endpoint;

	@Value("${oss.accessId}")
	private String accessId;

	@Value("${oss.accessKey}")
	private String accessKey;

	@Value("${oss.bucket}")
	private String bucket;

	@Value("${oss.replace.url}")
	private String replaceUrl;
	
	
	/**
	 * 获取oss签名
	 * 
	 * @param response
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/oss/sign", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getSign(HttpServletResponse response, HttpServletRequest request) {
		return getOssSign("","");
	}
	
	private Map<String,Object> getOssSign(String type, String name){
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("flag", false);
		StringBuilder dir = new StringBuilder();
		if ("system".equals(type)) {
			dir.append("system/");
		} else {
			Account account = SecurityUserHolder.getCurrentUser();
			Assert.notNull(account, "获取不到当前用户!");
			dir.append(account.getUsername()).append("/");
		}
		dir.append(getNowDateStr());
		if (StringUtils.isNotBlank(name)) {
			dir.append("/").append(name);
		}
		String host = "http://" + bucket + "." + endpoint;
		OSSClient client = new OSSClient(host, accessId, accessKey);
		long expireTime = 1 * 24 * 60 * 60 * 1000;// 过期时间 保存1天
		long expireEndTime = System.currentTimeMillis() + expireTime;
		Date expiration = new Date(expireEndTime);
		PolicyConditions policyConds = new PolicyConditions();
		policyConds.addConditionItem(PolicyConditions.COND_CONTENT_LENGTH_RANGE, 0, 1048576000l);
		policyConds.addConditionItem(MatchMode.StartWith, PolicyConditions.COND_KEY, dir.toString());
		String postPolicy = client.generatePostPolicy(expiration, policyConds);
		try {
			byte[] binaryData = postPolicy.getBytes("utf-8");
			String encodedPolicy = BinaryUtil.toBase64String(binaryData);
			String postSignature = client.calculatePostSignature(postPolicy);
			resultMap.put("flag", true);
			resultMap.put("accessid", accessId);
			resultMap.put("policy", encodedPolicy);
			resultMap.put("signature", postSignature);
			resultMap.put("dir", dir);
			resultMap.put("host", host);
			resultMap.put("bucket", bucket);
			resultMap.put("expire", String.valueOf(expireEndTime / 1000));
			resultMap.put("replaceUrl", replaceUrl);

		} catch (UnsupportedEncodingException e) {
			resultMap.put("errorMsg", "获取签名失败");
			log.error("获取签名失败", e);
		}
		return resultMap;
	}
	
	private static String getNowDateStr() {
		SimpleDateFormat fm = new SimpleDateFormat("yyyyMM");
		Date date = new Date();
		return fm.format(date);
	}
}
