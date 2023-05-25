package com.driver.services;

import com.driver.models.*;
import com.driver.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService {

    @Autowired
    BlogRepository blogRepository2;
    @Autowired
    ImageRepository imageRepository2;

    public Image addImage(Integer blogId, String description, String dimensions){
        //add an image to the blog
        Blog blog=blogRepository2.findById(blogId).get();

        Image image=new Image();
        image.setDescription(description);
        image.setDimensions(dimensions);
        image.setBlog(blog);

        List<Image> images=blog.getImageList();
        images.add(image);
        blog.setImageList(images);

        Blog savedBlog=blogRepository2.save(blog);

        List<Image> imageList=savedBlog.getImageList();
        Image image1=imageList.get(imageList.size()-1);
        return image1;





    }

    public void deleteImage(Integer id){

        imageRepository2.deleteById(id);

    }

    public int countImagesInScreen(Integer id, String screenDimensions) {
        //Find the number of images of given dimensions that can fit in a screen having `screenDimensions`

        Image image=imageRepository2.findById(id).get();

        String dimension[]=image.getDimensions().split("X");
        int width= Integer.parseInt(dimension[0]);
        int height= Integer.parseInt(dimension[1]);

        int area=width*height;

        String screenDimension[]=screenDimensions.split("X");
        int screenWidth= Integer.parseInt(screenDimension[0]);
        int screenHeight= Integer.parseInt(screenDimension[1]);
        int screenArea=screenWidth*screenHeight;

        return (screenArea/area);



    }
}
