package fa.training.services;

import fa.training.entities.Magazine;
import java.util.*;
import java.util.stream.Collectors;

public class MagazineService {
    private List<Magazine> magazines = new ArrayList<>();

    public void addMagazine(Magazine magazine) {
        magazines.add(magazine);
    }

    public List<Magazine> getMagazines() {
        return magazines;
    }

    // Lấy top 10 magazine có volume lớn nhất
    public List<Magazine> getTop10ByVolume() {
        return magazines.stream()
                .sorted(Comparator.comparingInt(Magazine::getVolume).reversed())
                .limit(10)
                .collect(Collectors.toList());
    }

    // Lấy danh sách magazine theo publicationYear và publisher
    public List<Magazine> getMagazinesByYearAndPublisher(int year, String publisher) {
        return magazines.stream()
                .filter(m -> m.getPublicationYear() == year && m.getPublisher().equalsIgnoreCase(publisher))
                .collect(Collectors.toList());
    }

    // Tìm kiếm magazine theo author
    public List<Magazine> searchByAuthor(String author) {
        return magazines.stream()
                .filter(m -> m.getAuthor().equalsIgnoreCase(author))
                .collect(Collectors.toList());
    }

    // Tìm kiếm magazine theo publisher
    public List<Magazine> searchByPublisher(String publisher) {
        return magazines.stream()
                .filter(m -> m.getPublisher().equalsIgnoreCase(publisher))
                .collect(Collectors.toList());
    }
}
