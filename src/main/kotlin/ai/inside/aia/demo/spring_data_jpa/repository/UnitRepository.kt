package ai.inside.aia.demo.spring_data_jpa.repository

import ai.inside.aia.demo.spring_data_jpa.model.Unit
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UnitRepository: CrudRepository<Unit, Long> {
    @Query("select u from Unit u join u.pages p where u.id = :unitId and p.id = :pageId")
    fun findByUnitIdAndPageId(unitId: Long, pageId: Long): Optional<Unit>
}
