package SolidPrinciple.ISP.GoodCode;

public class Admin implements IAddProducts,IBuyProducts,IApproveProducts,IModifyProducts{
    @Override
    public boolean canAddProducts() {
        return false;
    }

    @Override
    public boolean canBuyProducts() {
        return false;
    }

    @Override
    public boolean canApproveProducts() {
        return false;
    }

    @Override
    public boolean canModifyProducts() {
        return false;
    }
}
