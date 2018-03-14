package com.vm.base.util;


public class BaseService extends CommonUtil {
    protected <T extends BasePo> T getObjectById(BaseCrudMapper<T> mapper, Long objId, BasePo.Status status, BasePo.IsDeleted isDeleted) {
        T object = mapper.select(objId);
        if (object == null) {
            return null;
        }
        if (!status.getCode().equals(object.getStatus())) {
            return null;
        }
        if (!isDeleted.getCode().equals(object.getIsDeleted())) {
            return null;
        }
        return object;
    }

    protected <T extends BasePo> T getObjectById(BaseCrudMapper<T> mapper, Long objId, BasePo.IsDeleted isDeleted) {
        T object = mapper.select(objId);
        if (object == null) {
            return null;
        }
        if (!isDeleted.getCode().equals(object.getIsDeleted())) {
            return null;
        }
        return object;
    }

}
