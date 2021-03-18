package com.domum.application;

import com.domum.entities.Contract;
import com.domum.entities.Installment;
import com.domum.services.ContractService;
import com.domum.services.PaypalPaymentService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter contract data:");
        System.out.print("Number: ");
        int number = sc.nextInt();
        sc.nextLine();
        System.out.print("Date (DD/MM/YYYY): ");
        Date date = sdf.parse(sc.nextLine());
        System.out.print("Contract value: ");
        double value = sc.nextDouble();
        System.out.print("Enter the number of installments: ");
        int quotas = sc.nextInt();

        Contract contract = new Contract(number, date, value);

        ContractService contractService = new ContractService(new PaypalPaymentService());

        contractService.processContract(contract, quotas);

        System.out.println("Installments:");
        for (Installment i : contract.getInstallments()){
            System.out.printf("%s - %.2f%n", sdf.format(i.getDueDate()), i.getAmount());
        }

        sc.close();
    }
}
