import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Set<Notebook> notebooks = new HashSet<>();
        notebooks.add(new Notebook("Dell", "XPS 13", 8, 256, "Windows 10", "Silver"));
        notebooks.add(new Notebook("Apple", "MacBook Pro", 16, 512, "macOS", "Space Gray"));
        notebooks.add(new Notebook("HP", "Pavilion", 8, 1000, "Windows 10", "Black"));
        notebooks.add(new Notebook("Asus", "ZenBook", 16, 256, "Windows 10", "Blue"));
        notebooks.add(new Notebook("Lenovo", "ThinkPad", 8, 512, "Windows 10", "Black"));

        filterNotebooks(notebooks);
    }

    public static void filterNotebooks(Set<Notebook> notebooks) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> criteria = new HashMap<>();

        System.out.println("Введите цифру, соответствующую необходимому критерию:");
        System.out.println("1 - ОЗУ");
        System.out.println("2 - Объем ЖД");
        System.out.println("3 - Операционная система");
        System.out.println("4 - Цвет");

        int criterion = scanner.nextInt();
        scanner.nextLine(); // consume newline

        switch (criterion) {
            case 1:
                System.out.print("Введите минимальное значение ОЗУ (в ГБ): ");
                criteria.put("ram", scanner.nextInt());
                break;
            case 2:
                System.out.print("Введите минимальное значение объема ЖД (в ГБ): ");
                criteria.put("hdd", scanner.nextInt());
                break;
            case 3:
                System.out.print("Введите операционную систему: ");
                criteria.put("os", scanner.nextLine().hashCode());
                break;
            case 4:
                System.out.print("Введите цвет: ");
                criteria.put("color", scanner.nextLine().hashCode());
                break;
            default:
                System.out.println("Неверный критерий.");
                return;
        }

        List<Notebook> filteredNotebooks = notebooks.stream().filter(notebook -> {
            boolean matches = true;
            for (Map.Entry<String, Integer> entry : criteria.entrySet()) {
                String key = entry.getKey();
                int value = entry.getValue();
                switch (key) {
                    case "ram":
                        matches &= notebook.getRam() >= value;
                        break;
                    case "hdd":
                        matches &= notebook.getHdd() >= value;
                        break;
                    case "os":
                        matches &= notebook.getOs().hashCode() == value;
                        break;
                    case "color":
                        matches &= notebook.getColor().hashCode() == value;
                        break;
                }
            }
            return matches;
        }).collect(Collectors.toList());

        if (filteredNotebooks.isEmpty()) {
            System.out.println("Ноутбуков, удовлетворяющих условиям, не найдено.");
        } else {
            System.out.println("Найденные ноутбуки:");
            filteredNotebooks.forEach(Notebook::printInfo);
        }
    }
}
