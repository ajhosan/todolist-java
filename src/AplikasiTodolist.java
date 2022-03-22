public class AplikasiTodolist {

    public  static  String[] model = new String[10];

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {
        viewShowTodoList();
    }

//    Menampilkan Todo List
    public  static void showTodoList(){
        System.out.println("Todo List");
        for (var i = 0; i< model.length; i++){
            var todo = model[i];
            var no = i + 1;

            if(todo != null){
                System.out.println(no + ". " + todo);
            }
        }
    }

    public static  void testShowTodoList(){
        model[0] = "Belajar Java";
        showTodoList();
    }

//    Menambah Todo List
    public  static  void addTodoList(String todo){
//        Cek apakah todo full
        var isFull = true;
        for (var i = 0; i< model.length; i++) {
            if (model[i] == null) {
                isFull = false;
                break;
            }
        }

//        Jika data Full resize arraynya
        if(isFull){
            var temp = model;
            model = new String[model.length * 2];

            for (int i = 0; i < temp.length; i++){
                model[i] = temp[i];
            }
        }

//        Add Todo List
        for(var i = 0; i< model.length; i++){
            if(model[i] == null){
                model[i] = todo;
                break;
            }
        }
    }

    public static void testAddTodoList(){
        for (var i = 1; i<= 50; i++){
            addTodoList("Todo Ke "+ i);
        }


        showTodoList();
    }

//    Menghapus Todo List
    public  static boolean removeTodoList(Integer numberId){
        if((numberId - 1) >= model.length){
            return false;
        }else if(model[numberId - 1] == null){
            return false;
        }else{
            for (int i = (numberId - 1); i < model.length; i++){
                if(i == (model.length) -1){
                    model[i] = null;
                }else{
                    model[i] = model[i +1];
                }
            }
            return true;
        }
    }

    public  static void testRemoveTodoList(){
        addTodoList("Data 1");
        addTodoList("Data 2");
        addTodoList("Data 3");
        addTodoList("Data 4");
        addTodoList("Data 5");
        addTodoList("Data 6");

        var result = removeTodoList(20);

        result = removeTodoList(2);
        System.out.println(result);

        showTodoList();
    }

    public static String input(String info){
        System.out.print(info + " : ");
        String data = scanner.nextLine();
        return data;
    }

    public static void testInput(){
        var name = input("Nama");
        System.out.println("Hi" + name);
    }


//    View show todo list
    public  static void viewShowTodoList(){
       while(true){
           showTodoList();

           System.out.println("MENU");
           System.out.println("1. Tambah");
           System.out.println("2. Hapus");
           System.out.println("x. Keluar");

           var input = input("Pilih");
           if (input.equals("1")){
               viewAddTodoList();
           }else if (input.equals("2")){
               viewRemoveTodoList();
           }else if (input.equals("x")){
               break;
           }else{
               System.out.println("Pilihan tidak dimengerti!");
           }
       }
    }

    public static void testViewTodoList(){
        addTodoList("Data 1");
        addTodoList("Data 2");
        addTodoList("Data 3");
        addTodoList("Data 4");
        addTodoList("Data 5");
        addTodoList("Data 6");
        viewShowTodoList();
    }

//    Menampilkan view tambah todo list
    public  static void viewAddTodoList(){
        System.out.println("Add Todo List");

        var todo = input("Todo (x jika batal)");

        if(todo.equals("x")){
//            Batal
        }else{
            addTodoList(todo);
        }
    }

    public static void showviewAddTodoList(){
//        addTodoList("Data 1");
//        addTodoList("Data 2");
//        addTodoList("Data 3");

        viewAddTodoList();
        showTodoList();
    }

//    Menampilkan view delete todo list
    public  static void viewRemoveTodoList(){
        System.out.println("Hapus Todo List");

        var number = input("Hapus todo by nomor yang dipilih (x jika batal)");

        if(number.equals("x")){
//            Batal
        }else{
           boolean success = removeTodoList(Integer.valueOf(number));
           if(!success){
               System.out.println("Gagal menghapus data : " + number);
           }
        }
    }

    public static void testViewRemoveTodoList(){
        addTodoList("Data 1");
        addTodoList("Data 2");
        addTodoList("Data 3");

        showTodoList();

        viewRemoveTodoList();

        showTodoList();
    }
}
