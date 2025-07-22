package liliana.session_7.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Map;

public interface StatisticalRepository {
    @Query("SELECT s.quantity FROM Seed s")
    int countRemainingSeeds();

    //Thống kê sản lượng sản phẩm đã thu hoạch và tiền thu được trong tháng.
    @Query("SELECT h.totalMoney FROM Harvest h")
    double totalHarvestMoneyThisMonth();

    // Thống kê số lượng phiếu chi trong tháng và tổng số tiền phải chi.
    @Query("SELECT SUM(p.money) FROM PaymentSlip p")
    double totalPaymentSlipsThisMonth();

    // Thống kê số tiền lãi/lỗ của 12 tháng trong năm.
    @Query
    Map<String, Double> profitLossOverYear();
}
