package org.goodStudy.designPattern.myStateMode;

import org.goodStudy.designPattern.stateMode.Active;

/**
 * @Author dingws
 * @PackageName JavaStudy
 * @Package org.goodStudy.designPattern.stateMode
 * @Date 2021/11/8 4:10 下午
 * @Version 1.0
 */
public class OrderContext {
    OrderState orderState;

    public void OrderContext(){
        orderState = new WaitPay();
    }

    public void Handle(Active active){
        orderState.Handle(active);
    }

    public void setOrderState(OrderState orderState) {
        this.orderState = orderState;
    }

    public static void main(String[] args) {
        OrderContext orderContext = new OrderContext();
        orderContext.setOrderState(new WaitPay());
        orderContext.Handle(Active.ACTIVE_PAY);

        System.out.println("-------");
        orderContext.Handle(Active.ACTIVE_VALUATE);
        System.out.println("-------");

        orderContext.setOrderState(new WaitSend());
        orderContext.Handle(Active.ACTIVE_SEND);
        orderContext.setOrderState(new WaitRecv());
        orderContext.Handle(Active.ACTIVE_RECV);
        orderContext.setOrderState(new WaitValuate());
        orderContext.Handle(Active.ACTIVE_VALUATE);
        orderContext.setOrderState(new Finished());
        orderContext.Handle(Active.ACTIVE_VALUATE);
    }
}
