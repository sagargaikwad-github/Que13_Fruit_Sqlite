package com.example.que13_sqlite_fruitdata;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.SearchView;


import java.io.ByteArrayOutputStream;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;


public class DBManager extends SQLiteOpenHelper {
    private Context context;
    private static final String dbname = "Fruit.db";
    int id;
    String name, short_desc, desc, email;
    ArrayList<FruitData> arrayList = new ArrayList<>();
    SQLiteDatabase db;
    //FruitData fruitData=new FruitData(this);
    ByteArrayOutputStream bytearrayoutputstream;
    MyAdapterRecyclerView myAdapterRecyclerView;


    public DBManager(Context context) {
        super(context, dbname, null, 2);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String qry = "create table tbl_register(id integer primary key autoincrement,name text,email text,phone text,password text)";
        String qry1 = "create table tbl_fruit(id integer primary key autoincrement,image text,name text,short_desc text,description text,email text)";
        sqLiteDatabase.execSQL(qry);
        sqLiteDatabase.execSQL(qry1);




//        List<String> url = new ArrayList<String>();
//        url.add(0, "https://images.unsplash.com/photo-1453728013993-6d66e9c9123a?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80");
//        addphoto(0,url.get(0));


//
//         SQLiteDatabase db=this.getWritableDatabase();
//         ContentValues cv = new ContentValues();
//         cv.put("name", a1);
//         cv.put("email", a2);
//         cv.put("short_desc", a3);
//         long res=db.insert("tbl_fruit",null,cv);
//         if(res==-1)
//         {
//             Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
//         }
//
//         else
//         {
//             Toast.makeText(context, "True", Toast.LENGTH_SHORT).show();
//         }

//        arrayList.add(new FruitData(0,R.drawable.apple, "Apple", "An apple a day keeps the doctor away",
//                "        An apple is an edible fruit produced by an apple tree (Malus domestica). Apple trees are cultivated worldwide and are the most widely grown species in the genus Malus. The tree originated in Central Asia, where its wild ancestor, Malus sieversii, is still found today. Apples have been grown for thousands of years in Asia and Europe and were brought to North America by European colonists. Apples have religious and mythological significance in many cultures, including Norse, Greek, and European Christian tradition.\n" +
//                        "    Apples grown from seed tend to be very different from those of their parents, and the resultant fruit frequently lacks desired characteristics. Generally, apple cultivars are propagated by clonal grafting onto rootstocks. Apple trees grown without rootstocks tend to be larger and much slower to fruit after planting. Rootstocks are used to control the speed of growth and the size of the resulting tree, allowing for easier harvesting.\n" +
//                        "    There are more than 7,500 known cultivars of apples. Different cultivars are bred for various tastes and uses, including cooking, eating raw, and cider production. Trees and fruit are prone to a number of fungal, bacterial, and pest problems, which can be controlled by a number of organic and non-organic means. In 2010, the fruit's genome was sequenced as part of research on disease control and selective breeding in apple production.", "https://en.wikipedia.org/wiki/Apple"));
//        arrayList.add(new FruitData(1,R.drawable.bananas, "Banana", "Goals are like bananas, they come in bunches.", "      A banana is an elongated, edible fruit – botanically a berry – produced by several kinds of large herbaceous flowering plants in the genus Musa. In some countries, bananas used for cooking may be called \"plantains\", distinguishing them from dessert bananas. The fruit is variable in size, color, and firmness, but is usually elongated and curved, with soft flesh rich in starch covered with a rind, which may be green, yellow, red, purple, or brown when ripe. The fruits grow upward in clusters near the top of the plant. Almost all modern edible seedless (parthenocarp) bananas come from two wild species – Musa acuminata and Musa balbisiana. The scientific names of most cultivated bananas are Musa acuminata, Musa balbisiana, and Musa × paradisiaca for the hybrid Musa acuminata × M. balbisiana, depending on their genomic constitution. The old scientific name for this hybrid, Musa sapientum, is no longer used.", "https://en.wikipedia.org/wiki/Bananas"));
//        arrayList.add(new FruitData(2,R.drawable.lemon, "Lemon", "When life gives you lemons, learn to juggle.", "      The lemon (Citrus limon) is a species of small evergreen trees in the flowering plant family Rutaceae, native to Asia, primarily Northeast India (Assam), Northern Myanmar or China.\n" + "    The tree's ellipsoidal yellow fruit is used for culinary and non-culinary purposes throughout the world, primarily for its juice, which has both culinary and cleaning uses.[2] The pulp and rind are also used in cooking and baking. The juice of the lemon is about 5% to 6% citric acid, with a pH of around 2.2, giving it a sour taste. The distinctive sour taste of lemon juice makes it a key ingredient in drinks and foods such as lemonade and lemon meringue pie.", "https://en.wikipedia.org/wiki/Lemon"));
//        arrayList.add(new FruitData(3,R.drawable.orange, "Orange", "Orange is red brought nearer to humanity by yellow.", "      An orange is a fruit of various citrus species in the family Rutaceae (see list of plants known as orange); it primarily refers to Citrus × sinensis, which is also called sweet orange, to distinguish it from the related Citrus × aurantium, referred to as bitter orange. The sweet orange reproduces asexually (apomixis through nucellar embryony); varieties of sweet orange arise through mutations.\n" + "   The orange is a hybrid between pomelo (Citrus maxima) and mandarin (Citrus reticulata). The chloroplast genome, and therefore the maternal line, is that of pomelo. The sweet orange has had its full genome sequenced.\n" +
//                "    The orange originated in a region encompassing Southern China, Northeast India, and Myanmar,and the earliest mention of the sweet orange was in Chinese literature in 314 BC. As of 1987, orange trees were found to be the most cultivated fruit tree in the world. Orange trees are widely grown in tropical and subtropical climates for their sweet fruit. The fruit of the orange tree can be eaten fresh, or processed for its juice or fragrant peel. As of 2012, sweet oranges accounted for approximately 70% of citrus production.", "https://en.wikipedia.org/wiki/Orange"));
//        arrayList.add(new FruitData(4,R.drawable.strawberry, "Strawberry", "Keep calm and eat a strawberry.", "      The garden strawberry (or simply strawberry; Fragaria × ananassa) is a widely grown hybrid species of the genus Fragaria, collectively known as the strawberries, which are cultivated worldwide for their fruit. The fruit is widely appreciated for its characteristic aroma, bright red color, juicy texture, and sweetness. It is consumed in large quantities, either fresh or in such prepared foods as jam, juice, pies, ice cream, milkshakes, and chocolates. Artificial strawberry flavorings and aromas are also widely used in products such as candy, soap, lip gloss, perfume, and many others.\n" + "    The garden strawberry was first bred in Brittany, France, in the 1750s via a cross of Fragaria virginiana from eastern North America and Fragaria chiloensis, which was brought from Chile by Amédée-François Frézier in 1714. Cultivars of Fragaria × ananassa have replaced, in commercial production, the woodland strawberry (Fragaria vesca), which was the first strawberry species cultivated in the early 17th century.", "https://en.wikipedia.org/wiki/Strawberry"));
//
//        arrayList.add(new FruitData(5,R.drawable.mango, "Mango", "Keep it cool diet with with mango bites spicy and enjoy be tight.", "      A mango is an edible stone fruit produced by the tropical tree Mangifera indica which is believed to have originated from the region between northwestern Myanmar, Bangladesh, and northeastern India. M. indica has been cultivated in South and Southeast Asia since ancient times resulting in two distinct types of modern mango cultivars: the \"Indian type\" and the \"Southeast Asian type\". Other species in the genus Mangifera also produce edible fruits that are also called \"mangoes\", the majority of which are found in the Malesian ecoregion.\n" + "     Mango trees grow to 30–40 m (98–131 ft) tall, with a crown radius of 10–15 m (33–49 ft). The trees are long-lived, as some specimens still fruit after 300 years.\n" +
//                "  In deep soil, the taproot descends to a depth of 6 m (20 ft), with profuse, wide-spreading feeder roots and anchor roots penetrating deeply into the soil. The leaves are evergreen, alternate, simple, 15–35 cm (5.9–13.8 in) long, and 6–16 cm (2.4–6.3 in) broad; when the leaves are young they are orange-pink, rapidly changing to a dark, glossy red, then dark green as they mature." +
//                "Worldwide, there are several hundred cultivars of mango. Depending on the cultivar, mango fruit varies in size, shape, sweetness, skin color, and flesh color which may be pale yellow, gold, green, or orange. Mango is the national fruit of India, Pakistan and the Philippines, while the mango tree is the national tree of Bangladesh", "https://en.wikipedia.org/wiki/Mango"));
//
//        arrayList.add(new FruitData(6,R.drawable.pineapple, "Pineapple", "Be a pineapple: Stand tall, wear a crown, and be sweet on the inside.", "      The pineapple (Ananas comosus) is a tropical plant with an edible fruit; it is the most economically significant plant in the family Bromeliaceae. The pineapple is indigenous to South America, where it has been cultivated for many centuries. The introduction of the pineapple to Europe in the 17th century made it a significant cultural icon of luxury. Since the 1820s, pineapple has been commercially grown in greenhouses and many tropical plantations." +
//                "\n" +
//                "    Pineapples grow as a small shrub; the individual flowers of the unpollinated plant fuse to form a multiple fruit. The plant is normally propagated from the offset produced at the top of the fruit, or from a side shoot, and typically mature within a year.", "https://en.wikipedia.org/wiki/Pineapple"));


//        Bitmap bm = BitmapFactory.decodeStream(fis);
//        ByteArrayOutputStream baos = new ByteArrayOutputStream();
//        bm.compress(Bitmap.CompressFormat.JPEG, 100 , baos);
//        byte[] b = baos.toByteArray();
//        encImage = Base64.encodeToString(b, Base64.DEFAULT);

//        try {
//            URL url = new URL("https://images.unsplash.com/photo-1453728013993-6d66e9c9123a?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80");
//            Bitmap image = BitmapFactory.decodeStream(url.openConnection().getInputStream());
//        } catch(IOException e) {
//            System.out.println(e);
//        }
        //Object PATH_TO_IMAGE="https://images.unsplash.com/photo-1453728013993-6d66e9c9123a?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80";


//        try {
//            URL url = new URL("https://images.unsplash.com/photo-1453728013993-6d66e9c9123a?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80");
//            Bitmap image = BitmapFactory.decodeStream(url.openConnection().getInputStream());
//        } catch(IOException e) {
//            System.out.println(e);
//        }


//        Bitmap bitmap = BitmapFactory.decodeFile(String.valueOf(R.drawable.apple));
//        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//        bitmap.compress(Bitmap.CompressFormat.PNG, 0, byteArrayOutputStream);
//        byte[] bytesImage = byteArrayOutputStream.toByteArray();
//
//        ContentValues contentValues = new ContentValues();
//        contentValues.put("Name", "MyImage");
//        contentValues.put("Image", bytesImage);
//        sqLiteDatabase.insert("ImageTable", null, contentValues);


        sqLiteDatabase.execSQL("Insert into tbl_fruit values(0,'image1','Apple', 'An apple a day keeps the doctor away', 'An apple is an edible fruit produced by an apple tree (Malus domestica). Apple trees are cultivated worldwide and are the most widely grown species in the genus Malus. The tree originated in Central Asia, where its wild ancestor, Malus sieversii, is still found today. Apples have been grown for thousands of years in Asia and Europe and were brought to North America by European colonists. Apples have religious and mythological significance in many cultures, including Norse, Greek, and European Christian tradition. Apples grown from seed tend to be very different from those of their parents, and the resultant fruit frequently lacks desired characteristics. Generally, apple cultivars are propagated by clonal grafting onto rootstocks. Apple trees grown without rootstocks tend to be larger and much slower to fruit after planting. Rootstocks are used to control the speed of growth and the size of the resulting tree, allowing for easier harvesting. There are more than 7,500 known cultivars of apples. Different cultivars are bred for various tastes and uses, including cooking, eating raw, and cider production. Trees and fruit are prone to a number of fungal, bacterial, and pest problems, which can be controlled by a number of organic and non-organic means. In 2010, the fruits genome was sequenced as part of research on disease control and selective breeding in apple production.', 'https://en.wikipedia.org/wiki/Apple\')");
        sqLiteDatabase.execSQL("Insert into tbl_fruit values(1,'image2', 'Banana', 'Goals are like bananas, they come in bunches.','A banana is an elongated, edible fruit – botanically a berry – produced by several kinds of large herbaceous flowering plants in the genus Musa. In some countries, bananas used for cooking may be called plantains, distinguishing them from dessert bananas. The fruit is variable in size- color- and firmness. but is usually elongated and curved with soft flesh rich in starch covered with a rind which may be green, yellow, red, purple or brown when ripe. The fruits grow upward in clusters near the top of the plant. Almost all modern edible seedless (parthenocarp) bananas come from two wild species – Musa acuminata and Musa balbisiana. The scientific names of most cultivated bananas are Musa acuminata, Musa balbisiana, and Musa × paradisiaca for the hybrid Musa acuminata × M. balbisiana, depending on their genomic constitution. The old scientific name for this hybrid, Musa sapientum, is no longer used.', 'https://en.wikipedia.org/wiki/Bananas\')");
        sqLiteDatabase.execSQL("Insert into tbl_fruit values(2,'image3','Lemon', 'When life gives you lemons, learn to juggle',' The lemon (Citrus limon) is a species of small evergreen trees in the flowering plant family Rutaceae, native to Asia, primarily Northeast India (Assam), Northern Myanmar or China. The tree ellipsoidal yellow fruit is used for culinary and non-culinary purposes throughout the world, primarily for its juice, which has both culinary and cleaning uses.The pulp and rind are also used in cooking and baking. The juice of the lemon is about 5% to 6% citric acid, with a pH of around 2.2, giving it a sour taste. The distinctive sour taste of lemon juice makes it a key ingredient in drinks and foods such as lemonade and lemon meringue pie.','https://en.wikipedia.org/wiki/Lemon\')");
        sqLiteDatabase.execSQL("Insert into tbl_fruit values(3,'image4','Orange','Orange is red brought nearer to humanity by yellow.', ' An orange is a fruit of various citrus species in the family Rutaceae (see list of plants known as orange); it primarily refers to Citrus × sinensis, which is also called sweet orange, to distinguish it from the related Citrus × aurantium, referred to as bitter orange. The sweet orange reproduces asexually (apomixis through nucellar embryony); varieties of sweet orange arise through mutations. The orange is a hybrid between pomelo (Citrus maxima) and mandarin (Citrus reticulata). The chloroplast genome, and therefore the maternal line, is that of pomelo. The sweet orange has had its full genome sequenced.  The orange originated in a region encompassing Southern China, Northeast India, and Myanmar,and the earliest mention of the sweet orange was in Chinese literature in 314 BC. As of 1987, orange trees were found to be the most cultivated fruit tree in the world. Orange trees are widely grown in tropical and subtropical climates for their sweet fruit. The fruit of the orange tree can be eaten fresh, or processed for its juice or fragrant peel. As of 2012, sweet oranges accounted for approximately 70% of citrus production.', 'https://en.wikipedia.org/wiki/Orange\')");
        sqLiteDatabase.execSQL("Insert into tbl_fruit values(4,'image5','Strawberry', 'Keep calm and eat a strawberry.','The garden strawberry (or simply strawberry; Fragaria × ananassa) is a widely grown hybrid species of the genus Fragaria, collectively known as the strawberries, which are cultivated worldwide for their fruit. The fruit is widely appreciated for its characteristic aroma, bright red color, juicy texture, and sweetness. It is consumed in large quantities, either fresh or in such prepared foods as jam, juice, pies, ice cream, milkshakes, and chocolates. Artificial strawberry flavorings and aromas are also widely used in products such as candy, soap, lip gloss, perfume, and many others. The garden strawberry was first bred in Brittany, France, in the 1750s via a cross of Fragaria virginiana from eastern North America and Fragaria chiloensis, which was brought from Chile by Amédée-François Frézier in 1714. Cultivars of Fragaria × ananassa have replaced, in commercial production, the woodland strawberry (Fragaria vesca), which was the first strawberry species cultivated in the early 17th century.', 'https://en.wikipedia.org/wiki/Strawberry\')");
        sqLiteDatabase.execSQL("Insert into tbl_fruit values(5,'image6','Mango', 'Keep it cool diet with with mango bites spicy and enjoy be tight','A mango is an edible stone fruit produced by the tropical tree Mangifera indica which is believed to have originated from the region between northwestern Myanmar, Bangladesh, and northeastern India. M. indica has been cultivated in South and Southeast Asia since ancient times resulting in two distinct types of modern mango cultivars: the Indian type and the Southeast Asian type. Other species in the genus Mangifera also produce edible fruits that are also called mangoes, the majority of which are found in the Malesian ecoregion. Mango trees grow to 30–40 m (98–131 ft) tall, with a crown radius of 10–15 m (33–49 ft). The trees are long-lived, as some specimens still fruit after 300 years. In deep soil, the taproot descends to a depth of 6 m (20 ft), with profuse, wide-spreading feeder roots and anchor roots penetrating deeply into the soil. The leaves are evergreen, alternate, simple, 15–35 cm (5.9–13.8 in) long, and 6–16 cm (2.4–6.3 in) broad; when the leaves are young they are orange-pink, rapidly changing to a dark, glossy red, then dark green as they mature. Worldwide, there are several hundred cultivars of mango. Depending on the cultivar, mango fruit varies in size, shape, sweetness, skin color, and flesh color which may be pale yellow, gold, green, or orange. Mango is the national fruit of India, Pakistan and the Philippines, while the mango tree is the national tree of Bangladesh', 'https://en.wikipedia.org/wiki/Mango\')");
        sqLiteDatabase.execSQL("Insert into tbl_fruit values(6,'image7','Pineapple', 'Be a pineapple: Stand tall, wear a crown, and be sweet on the inside.',  'The pineapple (Ananas comosus) is a tropical plant with an edible fruit; it is the most economically significant plant in the family Bromeliaceae. The pineapple is indigenous to South America, where it has been cultivated for many centuries. The introduction of the pineapple to Europe in the 17th century made it a significant cultural icon of luxury. Since the 1820s, pineapple has been commercially grown in greenhouses and many tropical plantations.  Pineapples grow as a small shrub; the individual flowers of the unpollinated plant fuse to form a multiple fruit. The plant is normally propagated from the offset produced at the top of the fruit, or from a side shoot, and typically mature within a year.', 'https://en.wikipedia.org/wiki/Pineapple\')");
        sqLiteDatabase.execSQL("Insert into tbl_fruit values(7,'image8','Watermelon', 'You live as much in me as water in watermelon.',  'Watermelon (Citrullus lanatus) is a flowering plant species of the Cucurbitaceae family and the name of its edible fruit. A scrambling and trailing vine-like plant, it is a highly cultivated fruit worldwide, with more than 1,000 varieties.Watermelon is grown in favorable climates from tropical to temperate regions worldwide for its large edible fruit, which is a berry with a hard rind and no internal divisions, and is botanically called a pepo. The sweet, juicy flesh is usually deep red to pink, with many black seeds, although seedless varieties exist. The fruit can be eaten raw or pickled, and the rind is edible after cooking. It may also be consumed as a juice or as an ingredient in mixed beverages.Kordofan melons from Sudan are the closest relatives and may be progenitors of modern, cultivated watermelons. Wild watermelon seeds were found in Uan Muhuggiag, a prehistoric site in Libya that dates to approximately 3500 BC.[3] Watermelons were domesticated in Egypt by 2000 BC, although they were not the sweet modern variety. Sweet dessert watermelons spread across the Mediterranean world during Roman times.Considerable breeding effort has developed disease-resistant varieties. Many cultivars are available that produce mature fruit within 100 days of planting. In 2017, China produced about two-thirds of the world total of watermelons.', 'https://en.wikipedia.org/wiki/Watermelon\')");
        sqLiteDatabase.execSQL("Insert into tbl_fruit values(8,'image9','Carrot', 'Why is a carrot more orange than an orange?',  'The carrot (Daucus carota subsp. sativus) is a root vegetable, typically orange in color, though purple, black, red, white, and yellow cultivars exist,[2][3][4] all of which are domesticated forms of the wild carrot, Daucus carota, native to Europe and Southwestern Asia. The plant probably originated in Persia and was originally cultivated for its leaves and seeds. The most commonly eaten part of the plant is the taproot, although the stems and leaves are also eaten. The domestic carrot has been selectively bred for its enlarged, more palatable, less woody-textured taproot. The carrot is a biennial plant in the umbellifer family, Apiaceae. At first, it grows a rosette of leaves while building up the enlarged taproot. Fast-growing cultivars mature within three months (90 days) of sowing the seed, while slower-maturing cultivars need a month longer (120 days). The roots contain high quantities of alpha- and beta-carotene, and are a good source of vitamin A, vitamin K, and vitamin B6. The United Nations Food and Agriculture Organization (FAO) reports that world production of carrots and turnips (these plants are combined by the FAO) for 2018 was 40 million tonnes, with 45% of the world total grown in China. Carrots are commonly consumed raw or cooked in various cuisines.', 'https://en.wikipedia.org/wiki/Carrot\')");
        sqLiteDatabase.execSQL("Insert into tbl_fruit values(9,'image10','Cherry', 'Have a cherry-on-top kind of day!',  'A cherry is the fruit of many plants of the genus Prunus, and is a fleshy drupe (stone fruit). Commercial cherries are obtained from cultivars of several species, such as the sweet Prunus avium and the sour Prunus cerasus. The name cherry also refers to the cherry tree and its wood, and is sometimes applied to almonds and visually similar flowering trees in the genus Prunus, as in ornamental cherry or cherry blossom. Wild cherry may refer to any of the cherry species growing outside cultivation, although Prunus avium is often referred to specifically by the name wild cherry in the British Isles.','https://en.wikipedia.org/wiki/Cherry\')");

//        addphoto(1);
        sqLiteDatabase.execSQL("ALTER TABLE tbl_fruit ADD COLUMN favourite int");

//        @SuppressLint("ResourceType") InputStream inputstream = context.getResources().openRawResource(R.drawable.apple);
//        Bitmap bitmap1 = BitmapFactory.decodeStream(inputstream);
//        bitmap1.compress(Bitmap.CompressFormat.JPEG,70,bytearrayoutputstream);
//        byte[] Byte = bytearrayoutputstream.toByteArray();
//        Bitmap bitmap2 = BitmapFactory.decodeByteArray(Byte,0,Byte.length);

//        Bitmap bitmap = BitmapFactory.decodeFile(String.valueOf(R.drawable.apple));
//        ByteArrayOutputStream baos = new ByteArrayOutputStream();
//        bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
//        byte[] b = baos.toByteArray();


        // updateimage(id,bitmap);


//        FruitData fruitData=new FruitData(this);
//        SQLiteDatabase db=this.getWritableDatabase();
//        ContentValues cv = new ContentValues();
//
//        // id=fruitData.getId();
//        image =fruitData.getImage();
//        name =fruitData.getName();
//        short_desc =fruitData.getShort_desc();
//        desc =fruitData.getDesc();
//        email=fruitData.getEmail();
//
//        //  cv.put("id",id);
//        cv.put("image",image);
//        cv.put("name", name);
//        cv.put("short_desc", short_desc);
//        cv.put("description", desc);
//        cv.put("email", email);
//
//        db.insert("tbl_fruit", null, cv);


    }


//    public ArrayList<FruitData> getlist() {
//        FruitData fruitData=new FruitData(this);
//        SQLiteDatabase db=this.getWritableDatabase();
//        ContentValues cv = new ContentValues();
//ArrayList<FruitData> newA=new ArrayList<>();
//        // id=fruitData.getId();
//        this.image =fruitData.getImage();
//        this.name =fruitData.getName();
//        this.short_desc =fruitData.getShort_desc();
//        this.desc =fruitData.getDesc();
//        email=fruitData.getEmail();
//
//        //  cv.put("id",id);
//        cv.put("image", this.image);
//        cv.put("name", this.name);
//        cv.put("short_desc", this.short_desc);
//        cv.put("description", this.desc);
//        cv.put("email", email);
//
//        newA.add(new FruitData(image,))
//        return getlist();
//
//    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        if(i1==2)
        {
            sqLiteDatabase.execSQL("ALTER TABLE tbl_fruit ADD COLUMN favourite int");
        }


    }

    public String addRecord(String p1, String p2, String p3, String p4) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("name", p1);
        cv.put("email", p2);
        cv.put("phone", p3);
        cv.put("password", p4);

        long res = db.insert("tbl_register", null, cv);
        if (res == -1)
            return "Failed";
        else
            return "Sucessfully Inserted";

    }

    public boolean checkusername(String username) {
        SQLiteDatabase mydb = this.getWritableDatabase();
        Cursor cursor = mydb.rawQuery("Select * from tbl_register where email=?", new String[]{username});

        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    public boolean login(String username, String password) {
        SQLiteDatabase mydb = this.getReadableDatabase();
        Cursor cursor = mydb.rawQuery("Select * from tbl_register where email=? and password=?", new String[]{username, password});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    //
    public void addFruit(int image, String name, String short_desc, String desc, String email) {
        SQLiteDatabase db = this.getWritableDatabase();
        for (int i = 0; i <= arrayList.size(); i++) {
            FruitData fruitData = new FruitData(this);
            //id=fruitData.getId();
            image = fruitData.getImage();
            name = fruitData.getName();
            short_desc = fruitData.getShort_desc();
            desc = fruitData.getDesc();
            email = fruitData.getEmail();

            ContentValues cv = new ContentValues();

            //  cv.put("id",id);
            cv.put("image", image);
            cv.put("name", name);
            cv.put("short_desc", short_desc);
            cv.put("description", desc);
            cv.put("email", email);

            db.insert("tbl_fruit", null, cv);

        }
    }

    public ArrayList<FruitData> getlist() {
        ArrayList<FruitData> list = new ArrayList<>();
        String qry = "select * from tbl_fruit";
        db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(qry, null);

        if (cursor.moveToFirst()) {
            do {
                int fruit_id = cursor.getInt(0);
                int fruit_image = cursor.getInt(1);
                String fruit_name = cursor.getString(2);
                String fruit_sd = cursor.getString(3);
                String fruit_desc = cursor.getString(4);
                String fruit_website = cursor.getString(5);
                int fruit_favourite = cursor.getInt(6);

                list.add(new FruitData(fruit_id, fruit_image, fruit_name, fruit_sd, fruit_desc, fruit_website,fruit_favourite));
            } while (cursor.moveToNext());
        } else {

        }
        return list;
    }

    public boolean update(int id, String name, String desc) {
        db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("id", id);
        cv.put("name", name);
        cv.put("description", desc);

        Cursor cursor = db.rawQuery("Select * from tbl_fruit where id=?", new String[]{String.valueOf(id)});
        if (cursor.getCount() > 0) {
            long result = db.update("tbl_fruit", cv, "id=?", new String[]{String.valueOf(id)});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    public void delete(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from tbl_fruit where id=?", new String[]{String.valueOf(id)});
        if (cursor.getCount() > 0) {
            db.delete("tbl_fruit", "id=?", new String[]{String.valueOf(id)});

//            if (result == -1) {
//                return false;
//            } else {
//                return true;
//            }
        }
        db.close();

    }


    public Bitmap addphoto(int id) {
//        try {
//            URL url = new URL(src);
//            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//            connection.setDoInput(true);
//            connection.connect();
//            InputStream input = connection.getInputStream();
//            Bitmap myBitmap = BitmapFactory.decodeStream(input);
//            convertBitmapToByteArray(id,myBitmap);
//            return myBitmap;
//
//        } catch (IOException e) {
//            e.printStackTrace();
//            return null;
//        }
        //SQLiteDatabase db = this.getWritableDatabase();
//        try {
//            FileInputStream fs = new FileInputStream(x);
//            byte[] imgbyte = new byte[fs.available()];
//            fs.read(imgbyte);
//
//            ContentValues cv=new ContentValues();
//            cv.put("id",id);
//            cv.put("image",imgbyte);
//            db.insert("tbl_fruit",null,cv);
//            fs.close();
//            return true;
//        } catch (IOException e) {
//            e.printStackTrace();
//            return false;
//        }

//        Bitmap bitmap = ((BitmapDrawable) context.getResources().getDrawable(R.drawable.apple)).getBitmap();
//        ByteArrayOutputStream stream = new ByteArrayOutputStream();
//        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
//        byte[] bitMapData = stream.toByteArray();


//       Drawable myDrawable =Resources.getSystem().getDrawable(R.drawable.apple);
//        Bitmap myLogo = ((BitmapDrawable) myDrawable).getBitmap();
//        ByteArrayOutputStream myLogoStream = new ByteArrayOutputStream();
//        myLogo.compress(Bitmap.CompressFormat.PNG, 100, myLogoStream);
//        byte[] myLogoByteArray = myLogoStream.toByteArray();


//        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.apple);
//        bytearray(bitmap);

//        @SuppressLint("ResourceType") InputStream is = context.getResources().openRawResource(R.drawable.apple);
//        Bitmap bitmap = BitmapFactory.decodeStream(is);

//        Bitmap myLogo = ((BitmapDrawable) ResourcesCompat.getDrawable(context.getResources(), R.drawable.apple, null)).getBitmap();
//        bytearray(myLogo);


//        Bitmap bitmap = BitmapFactory.decodeResource(Resources.getSystem(),R.drawable.apple);
//        ByteArrayOutputStream stream = new ByteArrayOutputStream();
//        bitmap.compress(Bitmap.CompressFormat.JPEG, 80, stream);
//        byte[] byteArray = stream.toByteArray();
        //bytearray(bitmap);


//        db=this.getWritableDatabase();
//        ContentValues cv=new ContentValues();
//        cv.put("id",id);
//        cv.put("image",source);
//        db.update("tbl_fruit",cv,"id=?", new String[]{String.valueOf(id)});


//    private byte[] convertBitmapToByteArray(int id,Bitmap myBitmap) {
//
//        ByteBuffer byteBuffer = ByteBuffer.allocate(myBitmap.getByteCount());
//        myBitmap.copyPixelsToBuffer(byteBuffer);
//        byteBuffer.rewind();
//
//
//
//        db=this.getWritableDatabase();
//        ContentValues cv=new ContentValues();
//        cv.put("image",byteBuffer.array());
//
//        Cursor cursor=db.rawQuery("Select * from tbl_fruit where id=?",new String[]{String.valueOf(id)});
//        if(cursor.getCount()>0)
//        {
//           db.update("tbl_fruit",cv,"id=?", new String[]{String.valueOf(id)});
//        }
//        return byteBuffer.array();
//
//    }

//
//        try {
//            URL url = new URL("https://images.unsplash.com/photo-1453728013993-6d66e9c9123a?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mnx8dmlld3xlbnwwfHwwfHw%3D&w=1000&q=80");
//            Bitmap image = BitmapFactory.decodeStream(url.openConnection().getInputStream());
//            bytearray(image);
//        } catch (IOException e) {
//            System.out.println(e);
//        }
        try {
            URL url = new URL("https://images.unsplash.com/photo-1453728013993-6d66e9c9123a?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mnx8dmlld3xlbnwwfHwwfHw%3D&w=1000&q=80");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
            Bitmap myBitmap = BitmapFactory.decodeStream(input);
            return myBitmap;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

}


    private void bytearray(Bitmap bitmap) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] byteArray = stream.toByteArray();

        db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("id",id);
        cv.put("image",byteArray);
        db.update("tbl_fruit",cv,"id=?", new String[]{String.valueOf(id)});
    }

    public void ins_favourite()
    {
        int favourite=0;
        db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("favourite", favourite);
        db.update("tbl_fruit",cv, null,null);
    }

    public void fav_update(int id,int val)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("favourite",val);
        db.update("tbl_fruit",cv,"id=?", new String[]{String.valueOf(id)});
    }
    public ArrayList<FruitData> fav_list()
    {
        ArrayList<FruitData> arrayList = new ArrayList<>();
        String qry = "select * from tbl_fruit where favourite=1;";
        db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(qry, null);

        if (cursor.moveToFirst()) {
            do {
                int fruit_id = cursor.getInt(0);
                int fruit_image = cursor.getInt(1);
                String fruit_name = cursor.getString(2);
                String fruit_sd = cursor.getString(3);
                String fruit_desc = cursor.getString(4);
                String fruit_website = cursor.getString(5);
                int fruit_favourite = cursor.getInt(6);


                arrayList.add(new FruitData(fruit_id, fruit_image, fruit_name, fruit_sd, fruit_desc, fruit_website,fruit_favourite));
            } while (cursor.moveToNext());
        } else {

        }
        return arrayList;
    }
}
