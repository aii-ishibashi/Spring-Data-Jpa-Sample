package ai.inside.aia.demo.spring_data_jpa.controller

import ai.inside.aia.demo.spring_data_jpa.model.Page
import ai.inside.aia.demo.spring_data_jpa.model.Unit
import ai.inside.aia.demo.spring_data_jpa.service.UnitService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class UnitController(private val unitService: UnitService) {
    @PostMapping("/units")
    fun saveUnit(@RequestBody registerParam: Unit.RegisterParam): Unit {
        return this.unitService.registerUnit(registerParam)
    }

    @PutMapping("/units/{unitId}")
    fun updateUnit(@PathVariable unitId: Long, @RequestBody updateParam: Unit.UpdateParam): Unit {
        return this.unitService.updateUnit(unitId, updateParam)
    }

    @DeleteMapping("/units/{unitId}")
    fun deleteUnit(@PathVariable unitId: Long) {
        this.unitService.deleteUnit(unitId)
    }

    @PostMapping("/units/{unitId}/pages")
    fun savePage(@PathVariable unitId: Long, @RequestBody registerParam: Page.RegisterParam): Unit {
        return this.unitService.registerPage(unitId, registerParam)
    }

    @PutMapping("/units/{unitId}/pages/{pageId}")
    fun updatePage(@PathVariable unitId: Long, @PathVariable pageId: Long, @RequestBody updateParam: Page.UpdateParam): Unit {
        return this.unitService.updatePage(unitId, pageId, updateParam)
    }

    @DeleteMapping("/units/{unitId}/pages/{pageId}")
    fun deletePage(@PathVariable unitId: Long, @PathVariable pageId: Long) {
        return this.unitService.deletePage(unitId, pageId)
    }

    @GetMapping("/units/{unitId}")
    fun selectUnit(@PathVariable unitId: Long): Unit {
        return this.unitService.selectUnit(unitId)
    }

    @GetMapping("/units/{unitId}/pages/{pageId}")
    fun selectUnit(@PathVariable unitId: Long, @PathVariable pageId: Long): Page {
        return this.unitService.selectPage(unitId, pageId)
    }
}
