package org.scraper;

public class Item {

    //Attributes
    private String title, description, price, imageUrl, itemUrl, sponsored;

    //Getters and Setters
    public String getTitle() {
        return  title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return  description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return  price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImageUrl() {
        return  imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getItemUrl() {
        return itemUrl;
    }

    public void setItemUrl(String itemUrl) {
        this.itemUrl = itemUrl;
    }

    public String getSponsored() {
        return  sponsored;
    }

    public void setSponsored(String sponsored) {
        this.sponsored = sponsored;
    }
}
