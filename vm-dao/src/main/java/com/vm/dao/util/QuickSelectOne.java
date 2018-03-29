package com.vm.dao.util;


public class QuickSelectOne {
    public final static <T extends BasePo> T getObjectById(BaseCrudMapper<T> mapper, Long objId, BasePo.Status status, BasePo.IsDeleted isDeleted) {
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

    public final static <T extends BasePo> T getObjectById(BaseCrudMapper<T> mapper, Long objId, BasePo.IsDeleted isDeleted) {
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
