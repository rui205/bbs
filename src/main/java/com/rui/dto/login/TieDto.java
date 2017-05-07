package com.rui.dto.login;

import com.rui.entity.login.TieCustom;

/**
 * Created by Administrator on 2017/4/7.
 */
public class TieDto {
    private static final long serialVersionUID = -6656726313888896577L;
    private TieCustom tieCustom;

    public TieDto(TieCustom tieCustom) {
        this.tieCustom = tieCustom;
    }

    public TieCustom getTieCustom() {
        return tieCustom;
    }

    public void setTieCustom(TieCustom tieCustom) {
        this.tieCustom = tieCustom;
    }
}
