package org.goodStudy.designPattern.stateMode;

/**
 * @Author dingws
 * @PackageName JavaStudy
 * @Package org.goodStudy.designPattern.stateMode
 * @Date 2021/11/8 4:10 下午
 * @Version 1.0
 */
public class OrderContext {
    State state = State.WAIT_PAY;

    OrderState orderState = new WaitPay();

    public void OrderContext(){
        orderState = new WaitPay();
    }

    public void Handle(){
        orderState.Handle(this);
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public OrderState getOrderState(){
        return this.orderState;
    }

    public void setOrderState(OrderState orderState) {
        this.orderState = orderState;
    }

    public static void main(String[] args) {
        OrderContext orderContext = new OrderContext();
        orderContext.Handle();
        orderContext.Handle();
        orderContext.Handle();
        orderContext.Handle();
        orderContext.Handle();
    }
}
