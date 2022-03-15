public class AplikasiTodolist {

    public  static  String[] model = new String[10];

    public static void main(String[] args) {
        testAddTodoList();
    }

//    Menampilkan Todo List
    public  static void showTodoList(){
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

//        Jika data Full kita resize arraynya
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
//            addTodoList("Apasih2");
        }


        showTodoList();
    }

//    Menghapus Todo List
    public  static void removeTodoList(){

    }

//    View show todo list
    public  static void viewShowTodoList(){

    }

//    Menampilkan view tambah todo list
    public  static void viewAddTodoList(){

    }

//    Menampilkan view delete todo list
    public  static void viewRemoveTodoList(){

    }
}
