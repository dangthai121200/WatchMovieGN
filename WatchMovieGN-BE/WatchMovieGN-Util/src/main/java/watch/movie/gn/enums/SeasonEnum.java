package watch.movie.gn.enums;

import lombok.Getter;

@Getter
public enum SeasonEnum {
	SPRING_2000(1, "SPRING 2000", 2000), SUMMER_2000(2, "SUMMER 2000", 2000), FALL_2000(3, "FALL 2000", 2000),
	WINTER_2000(4, "WINTER 2000", 2000), SPRING_2001(5, "SPRING 2001", 2001), SUMMER_2001(6, "SUMMER 2001", 2001),
	FALL_2001(7, "FALL 2001", 2001), WINTER_2001(8, "WINTER 2001", 2001), SPRING_2002(9, "SPRING 2002", 2002),
	SUMMER_2002(10, "SUMMER 2002", 2002), FALL_2002(11, "FALL 2002", 2002), WINTER_2002(12, "WINTER 2002", 2002),
	SPRING_2003(13, "SPRING 2003", 2003), SUMMER_2003(14, "SUMMER 2003", 2003), FALL_2003(15, "FALL 2003", 2003),
	WINTER_2003(16, "WINTER 2003", 2003), SPRING_2004(17, "SPRING 2004", 2004), SUMMER_2004(18, "SUMMER 2004", 2004),
	FALL_2004(19, "FALL 2004", 2004), WINTER_2004(20, "WINTER 2004", 2004), SPRING_2005(21, "SPRING 2005", 2005),
	SUMMER_2005(22, "SUMMER 2005", 2005), FALL_2005(23, "FALL 2005", 2005), WINTER_2005(24, "WINTER 2005", 2005),
	SPRING_2006(25, "SPRING 2006", 2006), SUMMER_2006(26, "SUMMER 2006", 2006), FALL_2006(27, "FALL 2006", 2006),
	WINTER_2006(28, "WINTER 2006", 2006), SPRING_2007(29, "SPRING 2007", 2007), SUMMER_2007(30, "SUMMER 2007", 2007),
	FALL_2007(31, "FALL 2007", 2007), WINTER_2007(32, "WINTER 2007", 2007), SPRING_2008(33, "SPRING 2008", 2008),
	SUMMER_2008(34, "SUMMER 2008", 2008), FALL_2008(35, "FALL 2008", 2008), WINTER_2008(36, "WINTER 2008", 2008),
	SPRING_2009(37, "SPRING 2009", 2009), SUMMER_2009(38, "SUMMER 2009", 2009), FALL_2009(39, "FALL 2009", 2009),
	WINTER_2009(40, "WINTER 2009", 2009), SPRING_2010(41, "SPRING 2010", 2010), SUMMER_2010(42, "SUMMER 2010", 2010),
	FALL_2010(43, "FALL 2010", 2010), WINTER_2010(44, "WINTER 2010", 2010), SPRING_2011(45, "SPRING 2011", 2011),
	SUMMER_2011(46, "SUMMER 2011", 2011), FALL_2011(47, "FALL 2011", 2011), WINTER_2011(48, "WINTER 2011", 2011),
	SPRING_2012(49, "SPRING 2012", 2012), SUMMER_2012(50, "SUMMER 2012", 2012), FALL_2012(51, "FALL 2012", 2012),
	WINTER_2012(52, "WINTER 2012", 2012), SPRING_2013(53, "SPRING 2013", 2013), SUMMER_2013(54, "SUMMER 2013", 2013),
	FALL_2013(55, "FALL 2013", 2013), WINTER_2013(56, "WINTER 2013", 2013), SPRING_2014(57, "SPRING 2014", 2014),
	SUMMER_2014(58, "SUMMER 2014", 2014), FALL_2014(59, "FALL 2014", 2014), WINTER_2014(60, "WINTER 2014", 2014),
	SPRING_2015(61, "SPRING 2015", 2015), SUMMER_2015(62, "SUMMER 2015", 2015), FALL_2015(63, "FALL 2015", 2015),
	WINTER_2015(64, "WINTER 2015", 2015), SPRING_2016(65, "SPRING 2016", 2016), SUMMER_2016(66, "SUMMER 2016", 2016),
	FALL_2016(67, "FALL 2016", 2016), WINTER_2016(68, "WINTER 2016", 2016), SPRING_2017(69, "SPRING 2017", 2017),
	SUMMER_2017(70, "SUMMER 2017", 2017), FALL_2017(71, "FALL 2017", 2017), WINTER_2017(72, "WINTER 2017", 2017),
	SPRING_2018(73, "SPRING 2018", 2018), SUMMER_2018(74, "SUMMER 2018", 2018), FALL_2018(75, "FALL 2018", 2018),
	WINTER_2018(76, "WINTER 2018", 2018), SPRING_2019(77, "SPRING 2019", 2019), SUMMER_2019(78, "SUMMER 2019", 2019),
	FALL_2019(79, "FALL 2019", 2019), WINTER_2019(80, "WINTER 2019", 2019), SPRING_2020(81, "SPRING 2020", 2020),
	SUMMER_2020(82, "SUMMER 2020", 2020), FALL_2020(83, "FALL 2020", 2020), WINTER_2020(84, "WINTER 2020", 2020),
	SPRING_2021(85, "SPRING 2021", 2021), SUMMER_2021(86, "SUMMER 2021", 2021), FALL_2021(87, "FALL 2021", 2021),
	WINTER_2021(88, "WINTER 2021", 2021), SPRING_2022(89, "SPRING 2022", 2022), SUMMER_2022(90, "SUMMER 2022", 2022),
	FALL_2022(91, "FALL 2022", 2022), WINTER_2022(92, "WINTER 2022", 2022), SPRING_2023(93, "SPRING 2023", 2023),
	SUMMER_2023(94, "SUMMER 2023", 2023), FALL_2023(95, "FALL 2023", 2023), WINTER_2023(96, "WINTER 2023", 2023);

	private SeasonEnum(Integer pkIdSeason, String name, Integer year) {
		this.pkIdSeason = pkIdSeason;
		this.name = name;
		this.year = year;
	}

	private Integer pkIdSeason;
	private String name;
	private Integer year;

}
