package org.goodStudy.designPattern.myStateMode;


import org.goodStudy.designPattern.stateMode.Active;
import org.goodStudy.designPattern.stateMode.State;

/**
 * @Author dingws
 * @PackageName JavaStudy
 * @Package org.goodStudy.designPattern.stateMode
 * @Date 2021/11/2 2:15 下午
 * @Version 1.0
 */
public class OrderState {
    protected State state = State.FINISHED;

    void OrderState(){
        state = State.FINISHED;
    }

    public void Handle(Active active){

    }
}

class WaitPay extends OrderState {

    @Override
    public void Handle(Active active){
        if (active == Active.ACTIVE_PAY){
            System.out.println("用户已付款，等待发货");
            this.state = State.WAIT_SEND;
        } else if (active == Active.ACTIVE_CACLE) {
            this.state = State.FINISHED;
        } else {
            System.out.println("等待用户支付，当前订单状态为：" + state.getName());
        }
    }
}

class WaitSend extends OrderState {

    @Override
    public void Handle(Active active){
        if (active == Active.ACTIVE_SEND){
            System.out.println("卖家已发货，等待订单签收");
            this.state = State.WAIT_RECV;
        } else {
            System.out.println("等待卖家发货，当前订单状态为：" + state.getName());
        }
    }
}

class WaitRecv extends OrderState {

    @Override
    public void Handle(Active active){
        if (active == Active.ACTIVE_RECV){
            System.out.println("订单已签收，等待用户评价");
            this.state = State.WAIT_VALUATE;
        } else if (active == Active.ACTIVE_CACLE) {
            if (state == State.WAIT_SEND){
                System.out.println("商品未发货，取消订单成功");
                this.state = State.FINISHED;
            } else {
                System.out.println("商品未发货，取消订单失败");
            }
        }  else {
            System.out.println("等待用户签收订单，当前订单状态为：" + state.getName());
        }
    }
}

class WaitValuate extends OrderState {

    @Override
    public void Handle(Active active){
        if (active == Active.ACTIVE_VALUATE){
            System.out.println("用户已评价，订单关闭");
            this.state = State.FINISHED;
        } else {
            System.out.println("等待卖家发货，当前订单状态为：" + state.getName());
        }
    }
}

class Finished extends OrderState{

    @Override
    public void Handle(Active active){
        if (state == State.FINISHED){
            System.out.println("订单已完成");
        } else {
            System.out.println("等待订单完成，当前订单状态为：" + state.getName());
        }
    }
}
