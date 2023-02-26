# MOROZ_HW_9
ДЗ 9. Работа с файлами

1. Створити клас src.main.java.hillel.hw.filelogger.src.main.java.hillel.hw.filelogger.FileLogger. Клас здійснюватиме логування (протоколування)
інформації в зазначений файл на підставі конфігураційного об'єкта.

2. Створити перелік src.main.java.hillel.hw.filelogger.src.main.java.hillel.hw.logger.LoggingLevel. Складається із значень: INFO, DEBUG. 
Таблиця видимості:
| LEVEL | INFO | DEBUG |
| INFO   | X | |   
| DEBUG | X | X |
Тобто, якщо активовано рівень DEBUG, то його також включається INFO, але не навпаки.

3. Створити клас src.main.java.hillel.hw.filelogger.src.main.java.hillel.hw.filelogger.FileLoggerConfiguration. Клас представляє конфігурацію для логування.
Складається з властивостей: файл, куди буде записуватися інформація, поточний рівень логування,
максимальний розмір файлу (в байтах), формат для запису в файл. 

3. У класі src.main.java.hillel.hw.filelogger.src.main.java.hillel.hw.filelogger.FileLogger. Створити методи debug та info, які як параметр приймають рядок-повідомлення.
Метод повинен виконувати запис у вказаний у конфігурації файл у встановленому форматі для запису з конфігурації. 
Формат запису: [ПОТОЧНИЙ_ЧАС][DEBUG] Повідомлення: [СТРОКА-ПОВІДОМЛЕННЯ]

4. При виконанні методів debug та info врахувати максимально допустимий розмір файлу, куди будуть записуватися логи.
При досягненні максимального розміру файлу або його перевищення, викинути виняток src.main.java.hillel.hw.exception.FileMaxSizeReachedException
з повідомленням максимального і поточного розміру файлу, шляхи до файлу.

5. * Створити клас src.main.java.hillel.hw.filelogger.src.main.java.hillel.hw.filelogger.FileLoggerConfigurationLoader. Об'єкт даного типу за допомогою методу load,
завантажуватиме конфігурацію для логування із зазначеного файлу. Метод повертає об'єкт типу src.main.java.hillel.hw.filelogger.src.main.java.hillel.hw.filelogger.FileLoggerConfiguration.
Зміст файлу:
FILE: ТУТ_ШЛЯХ_До_ФАЙЛУ
LEVEL: ТУТ_РІВЕНЬ
MAX-SIZE: ТУТ_РАЗМІР
FORMAT: ТУТ_ФОРМАТ

6. ** При досягненні максимального розміру файлу або його перевищенні, створювати новий (додатковий) файл для зберігання .
Ім'я кожного нового файлу має містити дату створення.
Зразкова ситуація:
Log_11.11.2021-11:11.txt
Log_11.11.2021-12:11.txt
Log_11.11.2021-13:11.txt
ВАЖЛИВО! Формат іменування можна вибрати самостійно, головне не відступати від вимог завдання.

7. **** Спроектувати систему таким чином, щоб виявити ідею поліморфізму та абстракції. При такому варіанті,
можливо кілька сімейств логування, їх конфігурування. Тобто, не має значення, яка реалізація надалі буде обрана до використання,
не буде потреби зміни коду в місцях застосування логування. Відбувається лише підміна реалізації.
Виклик src.main.java.hillel.hw.logger.info("test log") буде однакового працювати при файловому або консольному логуванні.
Наприклад, може бути: 
src.main.java.hillel.hw.filelogger.src.main.java.hillel.hw.filelogger.FileLogger, src.main.java.hillel.hw.filelogger.src.main.java.hillel.hw.filelogger.FileLoggerConfiguration, src.main.java.hillel.hw.filelogger.src.main.java.hillel.hw.filelogger.FileLoggerConfigurationLoader
StdoutLogger, StdoutLoggerConfiguration, StdoutLoggerConfigurationLoader
ВАЖЛИВО! StdoutXXX реалізувати необов'язково, але система повинна бути до реалізації нового сімейства з можливістю управління "всім як одним".
Це завдання виконати окремою гілкою git.
