package org.goodStudy.designPattern.stateMode;

/**
 * @Author dingws
 * @PackageName JavaStudy
 * @Package org.goodStudy.designPattern.stateMode
 * @Date 2021/11/2 2:24 下午
 * @Version 1.0
 */
public enum Active {
    ACTIVE_PAY(1, "付款"),
    ACTIVE_SEND(2, "发货"),
    ACTIVE_RECV(3, "签收"),
    ACTIVE_VALUATE(4, "评价"),
    ACTIVE_CACLE(5, "取消");

    private final int id;
    private final String name;


    Active(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
