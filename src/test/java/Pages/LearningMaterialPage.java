package Pages;

import com.microsoft.playwright.Page;

public class LearningMaterialPage {
    Page page;

    private String learningMaterialTitle = "h2:has-text('Practice assassments')";
    //private String learningMaterialTitle = "xpath=//*[@id=\"root\"]/div/main/section/h2";
    private String learningMaterialsLocator = "button:has-text('Selenium Practice')";

    public LearningMaterialPage(Page page){
        this.page = page;
    }

    public boolean isLearningMaterialPageDisplayed() {
        return page.isVisible(learningMaterialTitle);
    }

    public LearningMaterialPage clickLearningMaterials() {
        page.click(learningMaterialsLocator);
        return new LearningMaterialPage(page);
}

}



