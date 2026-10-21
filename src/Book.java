public class Book {


    private final int id;
    private String title;
    private String author;
    private String category;
    private boolean available;

    public Book(int id, String title, String author,
                String category, boolean available) {
        this.id = id;
        this.title = requireText(title, "Title");
        this.author = requireText(author, "Author");
        this.category = requireText(category, "Category");
        this.available = available;
    }

    
    public static String requireText(String value, String fieldName) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException(fieldName + " must not be empty.");
        }
        return value.trim();
    }

    
    public int getId()            { return id; }
    public String getTitle()      { return title; }
    public String getAuthor()     { return author; }
    public String getCategory()   { return category; }
    public boolean isAvailable()  { return available; }

    
    public void setTitle(String title)       { this.title = requireText(title, "Title"); }
    public void setAuthor(String author)     { this.author = requireText(author, "Author"); }
    public void setCategory(String category) { this.category = requireText(category, "Category"); }
    public void setAvailable(boolean available) { this.available = available; }

    @Override
    public String toString() {
        return String.format("[ID: %d] %-32s | %-20s | %-12s | %s",
                id, title, author, category,
                available ? "Available" : "Borrowed");
    }
}
    
}
