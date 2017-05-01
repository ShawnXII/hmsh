package com.hmsh.admin.service.wms;

import javax.annotation.Resource;

import com.hmsh.admin.dao.wms.StorageDao;
import com.hmsh.admin.service.facade.wms.StorageFacadeService;

public class StorageService  implements StorageFacadeService {

	@Resource
	private StorageDao storageDao;

	


}
