package employeeregister;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		System.out.print("Quantos funcionários serão registrado? ");
		int n = scan.nextInt();
		scan.nextLine();

		List<Employee> employess = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			System.out.println("Funcionário #" + (i + 1));
			System.out.print("Id: ");
			Integer id = scan.nextInt();
			scan.nextLine();
			System.out.print("Nome: ");
			String name = scan.nextLine();
			System.out.print("Salário R$: ");
			Double salary = scan.nextDouble();

			Employee employee = new Employee(id, name, salary);

			employess.add(employee);
		}

		System.out.print("Entre com o id do funcionário que ira receber o aumento: ");
		int idEmployee = scan.nextInt();

		Employee emp = employess.stream().filter(x -> x.getId() == idEmployee).findFirst().orElse(null);

		if (emp == null) {
			System.out.println("Não existe funcionário com esse id");
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
