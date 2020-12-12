/**
 * Course
 *
 * a program that stores information
 *
 * about courses
 *
 * @author Rama Deshpande, CS180 Merge
 * @version October 12, 2020
 *
 */
public class Course
{
	private int	courseNumber; 
	private int	credits; 
	private java.lang.String department; 
	private java.lang.String description; 
	private Course[] prerequisites;	
	private java.lang.String professor; 
	private java.lang.String subject; 
	private int[][]	time; 
	
	public Course(java.lang.String subject, 
                  int courseNumber, 
                  java.lang.String department, 
                  int credits, Course[] prerequisites, 
                  java.lang.String description)
	{
		this.subject = subject;
		this.courseNumber = courseNumber;
		this.department = department;
		this.credits = credits;
		this.prerequisites = prerequisites;
		this.description = description;
	}
	
	public Course(java.lang.String subject, 
                   int courseNumber, 
                   java.lang.String department, 
                   java.lang.String professor, 
                   int credits, Course[] prerequisites, 
                   java.lang.String description, 
                   int[][] time)
	{
		this.subject = subject;
		this.courseNumber = courseNumber;
		this.department = department;
		this.professor = professor;
		this.credits = credits; 
		this.prerequisites = prerequisites;
		this.description = description;
		this.time = time;
	}
	
	public Course(java.lang.String subject, 
                  int courseNumber, 
                  java.lang.String department, 
                  java.lang.String professor, 
                  int credits, 
                  Course[] prerequisites, 
                  java.lang.String description) 
	{
		this.subject = subject;
		this.courseNumber = courseNumber;
		this.department = department;
		this.professor = professor;
		this.credits = credits; 
		this.prerequisites = prerequisites;
		this.description = description;
	}

	public boolean equals(java.lang.Object obj)
	{
		if (obj instanceof Course)
		{
			if (this.department.equals(((Course) obj).getDepartment()))
			{
				if (this.subject.equals(((Course) obj).getSubject()))
				{
					if (this.courseNumber == ((Course) obj).getCourseNumber())
					{
						return true;
					}
				}
			}
		}
		return false;
	}
	public int getCourseNumber()
	{
		return courseNumber;
	}
	public int getCredits()
	{
		return credits;
	}
	public java.lang.String getDepartment()
	{
		return department;
	}
	public java.lang.String getDescription()
	{
		return description;
	}
	public Course[] getPrerequisites()
	{
		return prerequisites;
	}
	public java.lang.String getProfessor()
	{
		return professor;
	}
	public java.lang.String getSubject()
	{
		return subject;
	}
	public int[][] getTime()
	{
		return time;
	}
	public void setCredits(int credits)
	{
		this.credits = credits;
	}
	public void	setDescription(java.lang.String description)
	{
		this.description = description;
	}
	public void	setPrerequisites(Course[] prerequisites)
	{
		this.prerequisites  = prerequisites;
	}
	public void	setProfessor(java.lang.String professor)
	{
		this.professor = professor;
	}
	public void	setTime(int[][] time)
	{
		this.time = time;
	}
}
