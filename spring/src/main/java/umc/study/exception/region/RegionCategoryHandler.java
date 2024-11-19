package umc.study.exception.region;

import umc.study.apiPayload.code.BaseErrorCode;
import umc.study.apiPayload.exception.GeneralException;

public class RegionCategoryHandler extends GeneralException {
    public RegionCategoryHandler(BaseErrorCode code) {
        super(code);
    }
}
