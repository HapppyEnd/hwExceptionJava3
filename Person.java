public class Person {
    private String lastName;
    private String firstName;
    private String patronumic;
    private String date;
    private int phone;
    private String sex;

    public Person(String[] args) {
        this.lastName = args[0];
        this.firstName = args[1];
        this.patronumic = args[2];
        this.date = this.isValidDate(args[3]);
        this.phone = this.checkPhone(args[4]);
        this.sex = this.checkSex(args[5]);
    }

    public String getLastName() {
        return lastName;
    }

    private int checkPhone(String phone) {
        try {
            return Integer.parseInt(phone);
        } catch (NumberFormatException e) {
            throw new RuntimeException(
                    "Неверный формат номера телефона.");
        }
    }

    private String checkSex(String sex) {
        if (sex.length() > 1 || !"fm".contains(sex)) {
            throw new RuntimeException(
                    " Некорректный ввод! Введите f или m.");
        }
        return sex;
    }

    private String isValidDate(String date) {
        if (!date.matches("^\\d{2}.\\d{2}.\\d{4}$")) {
            throw new RuntimeException(
                    "Некорректный ввод! Введите дату в формате дд.мм.гггг");
        }
        return date;
    }

    @Override
    public String toString() {
        return String.format(
                "<%s><%s><%s><%s><%s><%s> %n",
                this.lastName, this.firstName, this.patronumic, this.date,
                this.phone, this.sex);
    }
}
