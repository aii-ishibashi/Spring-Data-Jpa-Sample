package ai.inside.aia.demo.spring_data_jpa.model

import javax.persistence.*

@Entity
@Table(name="units")
class Unit(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,
    var name: String,

    // unidirectional(一方向)のone to many
    @OneToMany(cascade = [CascadeType.ALL])
    @JoinColumn(name="unit_id")
    var pages: MutableSet<Page> = mutableSetOf()
) {
    fun setPage(registerParam: Page.RegisterParam) {
        val page = Page(no = registerParam.no, itemName = registerParam.itemName)
        pages.add(page)
    }

    fun updateName(updateParam: UpdateParam) {
        this.name = updateParam.name
    }

    fun updatePageName(pageId: Long, updateParam: Page.UpdateParam) {
        val page = pages.find { it.id == pageId }!!
        page.updateName(updateParam)
    }

    fun deletePage(pageId: Long) {
        pages.removeIf { it.id == pageId } // 関連が消えるだけ。pageのdeleteはされない。
    }


    data class RegisterParam(
        val name: String
    )
    data class UpdateParam(
        val name: String
    )
}
