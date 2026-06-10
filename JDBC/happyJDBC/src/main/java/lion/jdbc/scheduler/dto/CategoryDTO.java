package lion.jdbc.scheduler.dto;

public class CategoryDTO {
    private int categoryId;
    private String name;
    private String colorCode;

    public CategoryDTO(){}

    public CategoryDTO(int categoryId, String name, String colorCode){
        this.categoryId = categoryId;
        this.name = name;
        this.colorCode = colorCode;
    }

    @Override
    public String toString() {
        return "CategoryDTO{" +
                "categoryId=" + categoryId +
                ", name='" + name + '\'' +
                ", colorCode='" + colorCode + '\'' +
                '}';
    }

    public String getColorCode() {
        return colorCode;
    }

    public void setColorCode(String colorCode) {
        this.colorCode = colorCode;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }




}
