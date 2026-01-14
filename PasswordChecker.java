public class PasswordChecker {
    private int minLength;
    private int maxRepeats;


    public void setMinLength(int minLength) {
        if (minLength > 0) {
            this.minLength = minLength;
        } else throw new IllegalArgumentException("Минимальная длина пароля должна быть положительной!");
    }

    public void setMaxRepeats(int maxRepeats){
        if (maxRepeats > 0) {
            this.maxRepeats = maxRepeats;
        } else throw new IllegalArgumentException("Максимальное количество повторений символа подряд должна быть положительной!");
    }
    public boolean verify(String password){

        if (maxRepeats != 0 && minLength !=0 ){
            if (password.length() >= minLength) {
                int chCount = 1;
                for (int i =0; i<= password.length()-2; i++){
                    if(password.charAt(i) == password.charAt(i+1)){
                        chCount +=1;
                    } else {
                        chCount = 1;
                    }
                    if (chCount >= maxRepeats){
                      return false;

                    }
                }

                return true;
            }
        }  else throw new IllegalStateException("Не заполнены настройки проверки пароля!");
        return false;
    }

}


//У этого класса должны быть методы-настройки:
//
//setMinLength — сеттер установки минимально допустимой длины пароля.
// Если в сеттер передали недопустимое значение (отрицательное число),
// то должно выкинуться исключение IllegalArgumentException,
// т. е. исключение недопустимого аргумента, с соответствующим сообщением;

//setMaxRepeats — сеттер установки максимально допустимого количества повторений символа подряд.
// Если в сеттер передали недопустимое значение (отрицательное число или 0),
// то должно выкинуться исключение IllegalArgumentException,
// т. е. исключение недопустимого аргумента, с соответствующим сообщением.

//И метод проверки boolean verify(String password), который проверяет переданный пароль
// на эти два критерия. Если пароль проходит, возвращает true, не проходит — false.
// Если до вызова метода verify хотя бы одна из двух вышеперечисленных настроек не была в
// ыставлена чекеру, то в нём кидается исключение IllegalStateException,
// т. е. исключение недопустимого состояния, с соответствующим сообщением.сообщением