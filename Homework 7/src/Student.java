/**
 * Student
 *
 * a program that stores information
 *
 * about students and their minors/majors/schedules
 *
 * @author Rama Deshpande, CS180 Merge
 * @version October 12, 2020
 *
 */
public class Student
{
	private int	age;
	private java.lang.String[] majors;
	private java.lang.String[] minors;
	private java.lang.String name;
	private Course[] previousCourses;
	private Course[][] schedule; //The current schedule of the student.

	public Student(String name, int age, String[] majors)
	{
		this.name = name;
		this.age = age;
		this.majors = majors;
	}
	public int addCourse(Course course)	//Add a course to the student's schedule.
	{
		int fulfilled = 0;
		if (course.getPrerequisites() == null)
		{
			return 1;
		}
		if (previousCourses == null)
		{
			return -1;
		}
		if (previousCourses.length == 0)
		{
			return -1;
		}
		for (Course c: course.getPrerequisites())
		{
			for (int i = 0; i < previousCourses.length; i++)
			{
				if (previousCourses[i].equals(c))
				{
					fulfilled++;
				}
			}
		}
		if (fulfilled == course.getPrerequisites().length - 1)
		{
			if (course.getTime() == null)
			{
				return -1;
			}
			if (schedule == null)
			{
				schedule = new Course[7][10];
			}
			for (int i = 0; i < schedule.length; i++)
			{
				for (int j = 0; j < schedule[i].length; j++)
				{
					if (course.getTime()[i][j] == 1 && schedule[i][j] == null)
					{
						schedule[i][j] = course;
						return 1;
					} else if (course.getTime()[i][j] == 1  && schedule[i][j] != null)
					{
						return -2;
					}
				}
			}
		}
		return -1;
	}
	public void	addMajor(String major)	//Adds a new major to the student's major list.
	{
		if (majors == null)
		{
			majors = new String []{major};
			return;
		}
		int majorsLength = majors.length;
		String [] addMajors = new String [majorsLength + 1];

		for (int i = 0; i < majors.length; i++)
		{
			addMajors[i] = majors[i];
		}
		addMajors[majorsLength - 1] = major;
		majors = new String[majorsLength + 1];
		majors = addMajors;
	}
	public void	addMinor(String minor)	//Adds a new minor to the student's minor list.
	{
		if (minors == null)
		{
			minors = new String []{minor};
		}
		int minorsLength = minors.length;
		String [] addMinors = new String [minorsLength + 1];

		for (int i = 0; i < minors.length; i++)
		{
			addMinors[i] = minors[i];
		}
		addMinors[minorsLength - 1] = minor;
		minors = new String[minorsLength + 1];
		minors = addMinors;
	}
	public int createSchedule(Course[] courseList)	//Creates the student's schedule, as per the course list argument.
	{
		if (courseList == null)
		{
			return 1;
		} else
		{
			schedule = new Course[7][10];
			for (Course course: courseList)
			{
				for (int i = 0; i < schedule.length; i++)
				{
					for (int j = 0; j < schedule[i].length; j++)
					{
						if (course.getTime()[i][j] == 1 && schedule[i][j] == null)
						{
							schedule[i][j] = course;
						} else if (course.getTime()[i][j] == 1 && schedule[i][j] != null)
						{
							return -1;
						}
					} 
				}
			}
		}
		return 1;
	}
	public boolean dropCourse(Course course)//Removes a course from the student's schedule.
	{
		if (course == null)
		{
			return false;
		}
		if (course.getTime() == null || schedule == null)
		{
			return false;
		}
		for (int i = 0; i < schedule.length; i++)
		{
			for (int j = 0; j < schedule[i].length; j++)
			{
				if (course.getTime()[i][j] == 1 && schedule[i][j] != null)
				{
					schedule[i][j] = null;
					return true;
				}
			}
		}
		return false;
	}
	public int getAge()	//gets the student's age
	{
		return age;
	}
	public String getName()	//gets the name of the student
	{
		return name;
	}
	public int removeMajor(String major)	
	{
		if (majors == null || major == null)
		{
			return -1;
		}
		if (majors.length == 0)
		{
			return -1;
		}
		int majorsLength = majors.length;
		boolean found = false;
		int removeIndex = -1;
		
		String[] newMajors = new String [majorsLength - 1];
		for (int i = 0; i < majors.length - 1; i++)
		{
			if (!majors[i].equals(major))
			{
				newMajors[i] = majors[i];
			} else if (majors[i].equals(major))
			{
				removeIndex = i;
				found = true;
			}
		}
		//added this in later
		majors = new String [majorsLength - 1];
		majors = newMajors;
		//
		if (found == true)
		{
			return removeIndex;
		} else
		{
			return -1;
		}
	}
	public int removeMinor(String minor)	
	{
		if (minors == null || minor == null)
		{
			return -1;
		}
		if (minors.length == 0)
		{
			return -1;
		}
		int minorsLength = minors.length;
		boolean found = false;
		int removeIndex = -1;
		String[] newMinors = new java.lang.String [minorsLength - 1];
		for (int i = 0; i < minors.length; i++)
		{
			if (!minors[i].equals(minor))
			{
				newMinors[i] = minors[i];
			} else if (minors[i].equals(minor))
			{
				removeIndex = i;
				found = true;
			}
		}
		if (found == true)
		{
			return removeIndex;
		} else
		{
			return -1;
		}
	}
	public void	setAge(int age)	//Sets the age of the student
	{
		this.age = age;
	}
	public void	setName(String name)	//sets the name of the student
	{
		this.name = name;
	}
	public static void main(String[] args) 
	{
        
    }
}