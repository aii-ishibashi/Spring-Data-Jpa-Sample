package ai.inside.aia.demo.spring_data_jpa.model

import javax.persistence.*

@Entity
@Table(name="pages")
class Page(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,
    var no: Long,
    var itemName: String,

// NOTE: 双方向の関連にしなくても使える
//    @ManyToOne(fetch = FetchType.LAZY)
//    @PrimaryKeyJoinColumn
//    val unit: Unit
) {
    fun updateName(updateParam: UpdateParam) {
        this.itemName = updateParam.itemName
    }

    data class RegisterParam(
        val no: Long,
        val itemName: String,
    )

    data class UpdateParam(
        val itemName: String
    )
}
