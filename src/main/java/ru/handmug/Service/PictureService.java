package ru.handmug.Service;

import org.springframework.stereotype.Service;
import ru.handmug.Entity.Picture;

import java.util.ArrayList;
import java.util.List;

@Service
public class PictureService {
    private List<Picture> pictures;

    public PictureService() {
        pictures = new ArrayList<Picture>() {{
           add(new Picture(0, "Кружка Пушистая овечка", "mug_1_m", "mug_1_s"));
        }};
    }

    public Picture getPictureById(int id) {
        for (Picture pic: pictures) {
            if (pic.getId() == id) {
                return pic;
            }
        }

        return null;
    }
}
