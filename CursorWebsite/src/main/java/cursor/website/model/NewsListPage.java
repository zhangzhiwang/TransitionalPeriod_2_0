package cursor.website.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 新闻列表页聚合数据：分类、头条、列表与分页信息。
 * （由 Curosr 自动生成）
 */
@Data
public class NewsListPage {

    /** 当前分类，空或 all 表示全部。 */
    private String category;

    /** 分类 Tab 列表。 */
    private List<String> categories = new ArrayList<String>();

    /** 头条精选（可为空）。 */
    private News featured;

    /** 当前页新闻列表。 */
    private List<News> items = new ArrayList<News>();

    /** 当前页码，从 1 开始。 */
    private int page;

    /** 每页条数。 */
    private int size;

    /** 是否还有下一页。 */
    private boolean hasMore;
}
