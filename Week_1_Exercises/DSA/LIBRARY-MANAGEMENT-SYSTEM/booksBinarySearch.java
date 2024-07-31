public class LibraryManagementSystem {

    // Binary search to find a book by title (assuming the list is sorted)
    public Book binarySearchByTitle(String title, int low, int high) {
        if (low <= high) {
            int mid = low + (high - low) / 2;
            int comparison = books[mid].getTitle().compareToIgnoreCase(title);

            if (comparison == 0) {
                return books[mid];
            } else if (comparison > 0) {
                return binarySearchByTitle(title, low, mid - 1);
            } else {
                return binarySearchByTitle(title, mid + 1, high);
            }
        }
        return null;
    }

    // Ensure books array is sorted before calling binarySearchByTitle
    public void sortBooksByTitle() {
        Arrays.sort(books, 0, count, Comparator.comparing(Book::getTitle, String.CASE_INSENSITIVE_ORDER));
    }
}
