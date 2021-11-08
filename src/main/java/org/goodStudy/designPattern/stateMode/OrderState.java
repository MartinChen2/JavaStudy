package org.goodStudy.designPattern.stateMode;


/**
 * @Author dingws
 * @PackageName JavaStudy
 * @Package org.goodStudy.designPattern.stateMode
 * @Date 2021/11/2 2:15 下午
 * @Version 1.0
 */
public abstract class OrderState {
    public abstract void Handle(OrderContext orderContext);
}

class WaitPay extends OrderState {

    @Override
    public void Handle(OrderContext orderContext) {
        if (orderContext.getState() == State.WAIT_PAY){
            System.out.println("用户已付款，等待发货");
            orderContext.setState(State.WAIT_SEND);
            orderContext.setOrderState(new WaitSend());
        } else {
            System.out.println("等待用户支付，当前订单状态为：" + orderContext.getState().getName());
        }
    }
}

class WaitSend extends OrderState {

    @Override
    public void Handle(OrderContext orderContext){
        if (orderContext.getState() == State.WAIT_SEND){
            System.out.println("卖家已发货，等待订单签收");
            orderContext.setState(State.WAIT_RECV);
            orderContext.setOrderState(new WaitRecv());
        } else {
            System.out.println("等待卖家发货，当前订单状态为：" + orderContext.getState().getName());
        }
    }
}

class WaitRecv extends OrderState {

    @Override
    public void Handle(OrderContext orderContext){
        if (orderContext.getState() == State.WAIT_RECV){
            System.out.println("订单已签收，等待用户评价");
            orderContext.setState(State.WAIT_VALUATE);
            orderContext.setOrderState(new WaitValuate());
        } else {
            System.out.println("等待用户签收订单，当前订单状态为：" + orderContext.getState().getName());
        }
    }
}

class WaitValuate extends OrderState {

    @Override
    public void Handle(OrderContext orderContext){
        if (orderContext.getState() == State.WAIT_VALUATE){
            System.out.println("用户已评价，订单关闭");
            orderContext.setState(State.FINISHED);
            orderContext.setOrderState(new Finished());
        } else {
            System.out.println("等待卖家发货，当前订单状态为：" + orderContext.getState().getName());
        }
    }
}

class Finished extends OrderState{

    @Override
    public void Handle(OrderContext orderContext){
        if (orderContext.getState() == State.FINISHED){
            System.out.println("订单已完成");
        } else {
            System.out.println("等待订单完成，当前订单状态为：" + orderContext.getState().getName());
        }
    }
}
