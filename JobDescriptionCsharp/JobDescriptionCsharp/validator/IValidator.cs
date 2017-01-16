using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace JobDescriptionCsharp.validator
{
    public interface IValidator<GenericType>
    {
        void validate(GenericType item);
    }
}
