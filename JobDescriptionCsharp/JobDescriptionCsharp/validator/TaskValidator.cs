using JobDescriptionCsharp.domain;
using JobDescriptionCsharp.exception;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace JobDescriptionCsharp.validator
{
    public class TaskValidator : IValidator<Task>
    {
        public void validate(Task task)
        {
            if (task.description == "")
            {
                throw new TaskException("The description of task can't be empty!");
            }
        }
    }
}
