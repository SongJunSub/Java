package class_01.example;

public class ProductOrderMain {

    public static void main(String[] args) {
        ProductOrder[] orders = new ProductOrder[3];

        ProductOrder order01 = new ProductOrder();
        order01.productName = "두부";
        order01.price = 2000;
        order01.quantity = 2;
        orders[0] = order01;

        ProductOrder order02 = new ProductOrder();
        order02.productName = "김치";
        order02.price = 5000;
        order02.quantity = 1;
        orders[1] = order02;

        ProductOrder order03 = new ProductOrder();
        order03.productName = "콜라";
        order03.price = 1500;
        order03.quantity = 2;
        orders[2] = order03;

        int totalAmount = 0;

        for (ProductOrder order : orders) {
            System.out.println("상품명 : " + order.productName + "\n" + "가격 : " + order.price + "\n" + "수량 : " + order.quantity);

            totalAmount += order.price * order.quantity;
        }

        System.out.println("총 결제 금액 : " + totalAmount);
    }

}