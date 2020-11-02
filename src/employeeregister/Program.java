package employeeregister;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		System.out.print("Quantos funcion�rios ser�o registrado? ");
		int n = scan.nextInt();
		scan.nextLine();

		List<Employee> employess = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			System.out.println("Funcion�rio #" + (i + 1));
			System.out.print("Id: ");
			Integer id = scan.nextInt();
			scan.nextLine();
			System.out.print("Nome: ");
			String name = scan.nextLine();
			System.out.print("Sal�rio R$: ");
			Double salary = scan.nextDouble();

			Employee employee = new Employee(id, name, salary);

			employess.add(employee);
		}

		System.out.print("Entre com o id do funcion�rio que ira receber o aumento: ");
		int idEmployee = scan.nextInt();

		Employee emp = employess.stream().filter(x -> x.getId() == idEmployee).findFirst().orElse(null);

		if (emp == null) {
			System.out.println("N�o existe funcion�rio com esse id");
		} else {
			System.out.print("Entre com a porcentage de aumento: ");
			double percentage = scan.nextDouble();
			emp.increaseSalary(percentage);
		}

		for (Employee e : employess) {
			System.out.println(e);
		}

		scan.close();
	}
}
