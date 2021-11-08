package org.goodStudy.designPattern.stateMode;

/**
 * @Author dingws
 * @PackageName JavaStudy
 * @Package org.goodStudy.designPattern.stateMode
 * @Date 2021/11/2 2:07 下午
 * @Version 1.0
 */
public enum State {
    WAIT_PAY(1, "待付款"),
    WAIT_SEND(2, "待发货"),
    WAIT_RECV(3, "待签收"),
    WAIT_VALUATE(4, "待评价"),
    FINISHED(5, "订单已完成");

    private final int id;
    private final String name;

    State(int id, String name){
        this.id = id;
        this.name = name;
    }

    State(State state){
        this.id = state.id;
        this.name = state.name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
