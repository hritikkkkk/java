package SolidPrinciple.LSP.CreditCards;

import SolidPrinciple.LSP.CreditCards.CreditCard;

public class VisaCard extends CreditCard implements IntPaymentsCompatability {

    @Override
    public void swipeAndPay() {

    }

    @Override
    public void tapAndPay() {

    }

    @Override
    public void mandatePayments() {

    }




    @Override
    public void onlineTransfer() {

    }

    @Override
    public void intlPayment() {

    }
}
