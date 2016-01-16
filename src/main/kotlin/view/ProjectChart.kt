package view

import javafx.scene.chart.BarChart
import javafx.scene.chart.CategoryAxis
import javafx.scene.chart.NumberAxis
import javafx.scene.chart.XYChart
import tornadofx.View
import java.util.*

class ProjectChart: View() {
    override val root = BarChart(CategoryAxis(), NumberAxis())

    init {
        root.xAxis.label = "Month"
        root.yAxis.label = "Amount"
        root.isLegendVisible = false

        val serie = XYChart.Series<String, Number>();

        val random = Random(99999)

        with (serie.data) {
            add(XYChart.Data("Jan", Math.abs(random.nextInt())))
            add(XYChart.Data("Feb", Math.abs(random.nextInt())))
            add(XYChart.Data("Mar", Math.abs(random.nextInt())))
            add(XYChart.Data("Apr", Math.abs(random.nextInt())))
            add(XYChart.Data("May", Math.abs(random.nextInt())))
            add(XYChart.Data("Jun", Math.abs(random.nextInt())))
            add(XYChart.Data("Jul", Math.abs(random.nextInt())))
            add(XYChart.Data("Aug", Math.abs(random.nextInt())))
            add(XYChart.Data("Sep", Math.abs(random.nextInt())))
            add(XYChart.Data("Oct", Math.abs(random.nextInt())))
        }

        root.data.add(serie);
    }
}