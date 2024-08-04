package watch.movie.gn.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import watch.movie.gn.enums.StatusRequestEnum;
import watch.movie.gn.util.ConstantDatabase;

@Getter
@Setter
@Builder
@AllArgsConstructor
@Entity(name = ConstantDatabase.TABLE_REQUEST_HISTORY)
@Table(name = ConstantDatabase.TABLE_REQUEST_HISTORY)
public class RequestHistoryEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = ConstantDatabase.COLUMN_REQUEST_HISTORY_ID)
    private String pkIdRequestHistory;

    @Column(name = ConstantDatabase.COLUMN_REQUEST_HISTORY_BODY, columnDefinition = "LONGTEXT")
    private String body;

    @Column(name = ConstantDatabase.COLUMN_CLASS_REQUEST_HISTORY_BODY, length = 100)
    private String className;

    @Enumerated(EnumType.STRING)
    @Column(name = ConstantDatabase.COLUMN_REQUEST_HISTORY_STATUS, nullable = false)
    private StatusRequestEnum status;

    @Column(name = ConstantDatabase.COLUMN_REQUEST_HISTORY_START, nullable = false, length = 100)
    private String start;

    @Column(name = ConstantDatabase.COLUMN_REQUEST_HISTORY_CALL_TO, nullable = false, length = 100)
    private String callTo;

    @Column(name = ConstantDatabase.COLUMN_REQUEST_REASON_ERROR, columnDefinition = "TEXT")
    private String reasonError;

    public RequestHistoryEntity() {

    }
}
