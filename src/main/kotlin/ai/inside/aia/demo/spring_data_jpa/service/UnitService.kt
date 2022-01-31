package ai.inside.aia.demo.spring_data_jpa.service

import ai.inside.aia.demo.spring_data_jpa.model.Page
import ai.inside.aia.demo.spring_data_jpa.model.Unit
import ai.inside.aia.demo.spring_data_jpa.repository.PageRepository
import ai.inside.aia.demo.spring_data_jpa.repository.UnitRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UnitService(private val unitRepository: UnitRepository, private val pageRepository: PageRepository) {
    @Transactional
    fun registerUnit(registerParam: Unit.RegisterParam): Unit {
        val unit = Unit(name = registerParam.name)
        this.unitRepository.save(unit)
        return unit
    }

    @Transactional
    fun updateUnit(unitId: Long, updateParam: Unit.UpdateParam): Unit {
        val unit = this.unitRepository.findById(unitId).orElseThrow()
        unit.updateName(updateParam)
        this.unitRepository.save(unit)
        return unit
    }

    @Transactional
    fun deleteUnit(unitId: Long) {
        this.unitRepository.deleteById(unitId)
    }

    @Transactional
    fun registerPage(unitId: Long, registerParam: Page.RegisterParam): Unit {
        val unit = this.unitRepository.findById(unitId).orElseThrow()
        unit.setPage(registerParam)
        this.unitRepository.save(unit)
        return unit
    }

    @Transactional
    fun updatePage(unitId: Long, pageId: Long, updateParam: Page.UpdateParam): Unit {
        val unit = this.unitRepository.findByUnitIdAndPageId(unitId, pageId).orElseThrow()
        unit.updatePageName(pageId, updateParam)
        this.unitRepository.save(unit)
        return unit
    }

    @Transactional
    fun deletePage(unitId: Long, pageId: Long) {
        val unit = this.unitRepository.findByUnitIdAndPageId(unitId, pageId).orElseThrow()
        unit.deletePage(pageId)
        this.pageRepository.deleteById(pageId)
        this.unitRepository.save(unit)
    }

    fun selectUnit(unitId: Long): Unit {
        return this.unitRepository.findById(unitId).get()
    }

    fun selectPage(unitId: Long, pageId: Long): Page {
        return this.pageRepository.findByUnitIdAndPageId(unitId, pageId).orElseThrow()
    }
}
