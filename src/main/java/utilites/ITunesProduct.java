package utilites;

public class ITunesProduct
{
    public String collectionName;
    public String previewUrl;
    public String country;
    public String releaseDate;

    void printIntroducePreview()
    {
        System.out.println(collectionName);
        System.out.println("Url to preview: " + previewUrl);
    }

    void printReleaseDate()
    {
        System.out.println(collectionName + " has released " + releaseDate);
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj instanceof ITunesProduct)
        {
            ITunesProduct productObj = (ITunesProduct) obj;
            return this.collectionName.equals(productObj.collectionName) && this.country.equals(productObj.country) && this.previewUrl.equals(productObj.previewUrl) && this.releaseDate.equals(productObj.releaseDate);
        } else return false;
    }

    public void setParams (String collectionName, String previewUrl, String country, String releaseDate)
    {
        this.collectionName = collectionName;
        this.previewUrl = previewUrl;
        this.country = country;
        this.releaseDate = releaseDate;
    }
}
