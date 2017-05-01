package com.hmsh.admin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hmsh.core.base.service.Service;
import com.hmsh.core.base.vo.BaseEntity;
import com.hmsh.core.exception.ControllerException;
import com.hmsh.core.tool.RequestData;

/**
 * BaseController 提供基础的增 改 查(单个查询/分页查询)接口 提供基础的参数解析方法
 * 
 * @author ShawnXII
 *
 * @param <T>
 * @param <PK>
 */
public abstract class BaseController<T extends BaseEntity<PK>, PK extends java.io.Serializable> {

	protected static final Logger log = LoggerFactory.getLogger(BaseController.class);

	/**
	 * 获取Service
	 * 
	 * @return
	 */
	public abstract Service<T, PK> getService();

	/**
	 * 主页
	 * 
	 * @param request
	 * @param session
	 * @return
	 */
	public abstract ModelAndView index(HttpServletRequest request, HttpSession session);

	/**
	 * 分页查询
	 * 
	 * @param request
	 * @param session
	 * @param entity
	 * @return
	 * @throws ControllerException
	 */
	@RequestMapping(value = { "/query" }, method = RequestMethod.GET)
	public @ResponseBody Page<T> query(HttpServletRequest request, HttpSession session, T entity)
			throws ControllerException {
		try {
			if (getService() == null) {
				throw new ControllerException("找不到Service!");
			}
			return getService().query(entity);
		} catch (Exception e) {
			log.error("分页查询异常!", e);
			throw new ControllerException(e.getMessage());
		}
	}

	/**
	 * 新增或者修改
	 * 
	 * @param request
	 * @param session
	 * @param entity
	 * @return
	 */
	@RequestMapping(value = { "/save" }, method = RequestMethod.POST)
	public @ResponseBody RequestData save(HttpServletRequest request, HttpSession session, T entity) {
		boolean flag = true;
		Object data = null;
		String message = "添加成功";
		try {
			if (getService() == null) {
				throw new Exception("找不到Service!");
			}
			if (entity.getId() != null) {
				data = getService().updateNotNull(entity);
				message = "修改成功";
			} else {
				data = getService().add(entity);
			}
		} catch (Exception e) {
			log.error("新增/保存数据异常!", e);
			flag = false;
			message = e.getMessage();
		}
		return new RequestData(flag, message, data);
	}

	/**
	 * 查询单个
	 * 
	 * @param id
	 * @return
	 * @throws ControllerException
	 */
	@RequestMapping(value = "/findone", method = RequestMethod.GET)
	public @ResponseBody T findone(@RequestParam(name = "id") PK id) throws ControllerException {
		try {
			if (getService() == null) {
				throw new ControllerException("找不到Service!");
			}
			T entity = getService().findOne(id);
			if (entity == null) {
				throw new Exception("查询结果不存在!");
			}
			return entity;
		} catch (Exception e) {
			log.error("查询数据异常!", e);
			throw new ControllerException(e.getMessage());
		}
	}
}
