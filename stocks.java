package oopsprinciple;
import java.util.Scanner;
public class Stock {
String name;
double price;
int quantity;
double totalPrice;
public Stock(String name, double price) {
this.name = name;
this.price = price;
}
public Stock(String name, double price, int quantity, double totalPrice) {
this.name = name;
this.price = price;
this.quantity = quantity;
this.totalPrice = totalPrice;
}
}
class OriginalStock {
int capacity;
int size;
Stock[] stocks;
public OriginalStock(int orgCapacity, int orgSize) {
capacity = orgCapacity;
size = orgSize;
stocks = new Stock[capacity];
}
public void addStock(String name, double price) {
if (capacity == size) {
System.out.println("Stock can't be purchased");
return;
}
stocks[size] = new Stock(name, price);
size++;
}
public void display() {
for (int i = 0; i < size; i++) {
System.out.println("Stock Name: " + stocks[i].name);
System.out.println("Stock Price: " + stocks[i].price);
}
}
public Stock getStock(String name) {
for (int i = 0; i < size; i++)
if (stocks[i].name.equals(name))
return stocks[i];
return null;
}
}
class PortfolioStock {
int capacity;
int size;
Stock[] stocks;
OriginalStock originalStock;
public PortfolioStock(int portCapacity, int portSize, OriginalStock
originalStock) {
capacity = portCapacity;
size = portSize;
stocks = new Stock[capacity];
this.originalStock = originalStock;
}
public void addStock(String name, int quantity) {
Stock isExist = originalStock.getStock(name);
if (isExist == null)
System.out.println("Invalid stock. Add operation can't be performed!");
else if (capacity == size)
System.out.println("Stock can't be purchased");
else {
stocks[size] = new Stock(name, isExist.price, quantity, isExist.price *
quantity);
size++;
}
}
public void display() {
for (int i = 0; i < size; i++) {
System.out.println("Stock Name: " + stocks[i].name);
System.out.println("Stock Price: " + stocks[i].price);
System.out.println("Stock Quantity: " + stocks[i].quantity);
System.out.println("Stock TotalPrice: " + stocks[i].totalPrice);
}
}
public void purchase(String name, int quantity) {
Stock tmp = originalStock.getStock(name);
if (tmp == null) {
System.out.println("Invalid stock. Purchase operation can't be performed!");
}
else if (capacity == size)
System.out.println("Stock can't be purchased");
else {
Stock curr = isExistInPortfolio(name);
if (curr != null) {
curr.quantity += quantity;
curr.totalPrice = curr.quantity * curr.price;
} else {
stocks[size] = new Stock(name, tmp.price, quantity, tmp.price *
quantity);
size++;
}
}
}
private Stock isExistInPortfolio(String name) {
for (int i = 0; i < size; i++)
if (stocks[i].name.equals(name))
return stocks[i];
return null;
}
public void sell(String name, int quantity) {
Stock tmp = originalStock.getStock(name);
if (tmp == null) {
System.out.println("Invalid stock. Sell operation can't be performed!");
return;
}
Stock curr = isExistInPortfolio(name);
if (curr == null)
System.out.println("Stock doesn't exist");
else {
if (curr.quantity < quantity)
System.out.println("Invalid stock quantity");
else {
curr.quantity -= quantity;
curr.totalPrice = curr.price * curr.quantity;
}
}
}
}
public class Main {
public static void main(String[] args) {
Scanner in = new Scanner((System.in));
int orgCapacity = in.nextInt();
int orgSize = in.nextInt();
Stocks.OriginalStock originalStock = new Stocks.OriginalStock(orgCapacity,orgSize);
for (int i = 0; i < orgSize; i++) {
String name = in.next();
double price = in.nextDouble();
Stock tmp = new Stock(name, price);
originalStock.stocks[i] = tmp;
}
int portCapacity = in.nextInt();
int portSize = in.nextInt();
PortfolioStock portfolioStock = new PortfolioStock(portCapacity, portSize,
originalStock);
for (int i = 0; i < portSize; i++) {
String name = in.next();
Stock curr = originalStock.getStock(name);
double price = curr.price;
int quantity = in.nextInt();
double totalPrice = price * quantity;
Stock tmp = new Stock(name, price, quantity, totalPrice);
portfolioStock.stocks[i] = tmp;
}
int choice = in.nextInt();
switch (choice) {
case 1:
String name = in.next();
originalStock.addStock(name, in.nextDouble());
originalStock.display();
break;
case 2:
portfolioStock.addStock(in.next(), in.nextInt());
portfolioStock.display();
break;
case 3:
originalStock.display();
break;
case 4:
portfolioStock.display();
break;
case 5:
portfolioStock.purchase(in.next(), in.nextInt());
portfolioStock.display();
break;
case 6:
portfolioStock.sell(in.next(), in.nextInt());
portfolioStock.display();
break;
}
}
}
