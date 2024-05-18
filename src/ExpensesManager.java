import java.util.ArrayList;
import java.util.HashMap;

public class ExpensesManager {
    HashMap<String, ArrayList<Double>> expensesByCategories;// замените на таблицу с именем expensesByCategories

    ExpensesManager() {
        expensesByCategories = new HashMap<>(); // создайте таблицу
    }

    // добавьте в метод ещё один параметр — category
    double saveExpense(double moneyBeforeSalary, double expense, String category) {
        moneyBeforeSalary = moneyBeforeSalary - expense;
        System.out.println("Значение сохранено! Ваш текущий баланс в рублях: " + moneyBeforeSalary);
        if (expensesByCategories.containsKey(category)) {// проверьте наличие категории
            ArrayList<Double> value = expensesByCategories.get(category); // получите список трат в этой категории
            value.add(expense); // добавьте трату
        } else {
            ArrayList<Double> value = new  ArrayList<>(); // создайте новый список трат и добавьте в него сумму
            value.add(expense);
            expensesByCategories.put(category,value) ;// сохраните категорию и новый список трат в хеш-таблицу
        }
        if (moneyBeforeSalary < 1000) {
            System.out.println("На вашем счету осталось совсем немного. Стоит начать экономить!");
        }
        return moneyBeforeSalary;
    }


    void printAllExpensesByCategories() {
        for(String expense:expensesByCategories.keySet()){
            System.out.println(expense);
            ArrayList<Double> value=expensesByCategories.get(expense);
            // замените логику для работы с таблицами
            for (int i = 0; i < value.size(); i++) {
                System.out.println(value.get(i));
            }
        }
    }
    // метод должен принимать название категории и называться findMaxExpenseInCategory
    double findMaxExpenseInCategory(String category) {
        double maxExpense = 0;
        if(expensesByCategories.containsKey(category)) {
            ArrayList<Double> value=expensesByCategories.get(category);
            for (int i = 0; i < value.size(); i++) if (maxExpense>value.get(i)) maxExpense=value.get(i);
            return maxExpense;
        } else  System.out.println("Такой категории пока нет.");
        /* Замените логику для работы с таблицами
        Если категория есть, то ищем максмальную трату.
        Иначе печатаем "Такой категории пока нет." */
        return maxExpense;
    }

    void removeAllExpenses() {
        expensesByCategories.clear(); // таблица называется иначе
        System.out.println("Траты удалены.");
    }
}