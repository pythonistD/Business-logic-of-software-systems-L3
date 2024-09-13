package cheboksarov.blps_lab3.service;

import cheboksarov.blps_lab3.model.Statistics;

public interface StatisticsService {
    Statistics findById(Long stat_id);
    Statistics save(Statistics statistics);

    Statistics createDefaultStatistics();

    Statistics updateStatistics(Statistics statistics);

    void deleteStatistics(Long statId);
}
