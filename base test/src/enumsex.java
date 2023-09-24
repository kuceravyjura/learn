public class enumsex {

    public static void main(String[] args) {

        Boook b1 = new Boook("War and Peace", "L. Tolstoy", Type.BELLETRE);
        System.out.printf("Book '%s' has a type %s", b1.name, b1.bookType);

        switch(b1.bookType){
            case BELLETRE:
                System.out.println("Belletre");
                break;
            case SCIENCE:
                System.out.println("Science");
                break;
            case SCIENCE_FICTION:
                System.out.println("Science fiction");
                break;
            case PHANTASY:
                System.out.println("Phantasy");
                break;
        }
    }
}
class Boook {

    String name;
    Type bookType;
    String author;

    Boook(String name, String author, Type type){

        bookType = type;
        this.name = name;
        this.author = author;
    }
}

enum Type
{
    SCIENCE,
    BELLETRE,
    PHANTASY,
    SCIENCE_FICTION
}