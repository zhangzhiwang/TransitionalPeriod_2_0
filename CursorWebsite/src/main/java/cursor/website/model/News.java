package cursor.website.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * 新闻实体，对应表 news。
 * （由 Curosr 自动生成）
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("news")
public class News {

    /** 新闻主键。 */
    @TableId(type = IdType.AUTO)
    private Long id;

    /** 新闻标题。 */
    private String title;

    /** 新闻摘要。 */
    private String summary;

    /** 封面图 URL。 */
    private String coverUrl;

    /** 分类名称。 */
    private String category;

    /** 作者。 */
    private String author;

    /** 正文 HTML。 */
    private String content;

    /** 是否头条。 */
    private Boolean featured;

    /** 阅读量。 */
    private Integer viewCount;

    /** 发布日期。 */
    private LocalDate publishDate;

    /** 发布状态：draft / published。 */
    private String status;
}
