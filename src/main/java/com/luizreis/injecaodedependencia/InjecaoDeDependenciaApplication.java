package com.luizreis.injecaodedependencia;

import com.luizreis.injecaodedependencia.entities.Order;
import com.luizreis.injecaodedependencia.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.Locale;
import java.util.Scanner;

@SpringBootApplication
@ComponentScan({"com.luizreis"})
public class InjecaoDeDependenciaApplication implements CommandLineRunner {
    @Autowired
    OrderService orderService;
    public static void main(String[] args){

        SpringApplication.run(InjecaoDeDependenciaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception{
        Locale.setDefault(Locale.US);

        Scanner sc = new Scanner(System.in);


        System.out.println("Pedido número: ");
        int code = sc.nextInt();
        System.out.println("Preço: ");
        double basic = sc.nextDouble();
        System.out.println("Desconto: ");
        double discount = sc.nextDouble();

        Order order = new Order(code,basic,discount);

        System.out.println("Pedido código " + order.getCode());
        System.out.println("Valor total R$" + orderService.total(order));
    }
}
